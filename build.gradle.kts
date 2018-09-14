import org.apache.tools.ant.taskdefs.condition.Os
import org.jetbrains.kotlin.gradle.tasks.Kotlin2JsCompile
import com.moowork.gradle.node.NodeExtension
import com.moowork.gradle.node.npm.NpmTask
import com.moowork.gradle.node.task.NodeTask

buildscript {
    var kotlinVer: String by extra
    kotlinVer = "1.2.40"
    repositories {
        mavenCentral()
    }
    repositories {
        maven {
            url = uri("https://plugins.gradle.org/m2/")
        }
    }

    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVer")
        classpath("com.moowork.gradle:gradle-node-plugin:1.2.0")
    }
}

group = "com.github.kotlin.ts2kt"
version = "1.0-SNAPSHOT"
var kotlinVer: String by extra
kotlinVer = "1.2.40"

repositories {
    mavenLocal()
    mavenCentral()
    jcenter()
}

apply {
    plugin("idea")
    plugin("kotlin2js")
    plugin("com.moowork.node")
}

dependencies {
    "compile"("org.jetbrains.kotlin:kotlin-stdlib-js:$kotlinVer")
    "testCompile"("org.jetbrains.kotlin:kotlin-test-js:$kotlinVer")
}

tasks {
    "clean" {
        doLast {
            file("out").deleteRecursively()
            file("$projectDir/node_modules").listFiles().forEach {
                if (it.isFile() && it.name.endsWith(".js")) it.delete()
            }
        }
    }

    val extractJsLibs by creating(Copy::class) {
        configurations["compile"].forEach {
            from(zipTree(it.absolutePath).matching { include("*.js") })
        }
        into("out/production/classes/lib")
    }

    val extractTestJsLibs by creating(Copy::class) {
        configurations["testCompile"].forEach {
            from(zipTree(it.absolutePath).matching { include("*.js") })
        }
        into("out/test/classes/lib")
    }

    val compileKotlin2Js by getting(Kotlin2JsCompile::class) {
        kotlinOptions.moduleKind = "commonjs"
        kotlinOptions.outputFile = "$projectDir/out/production/classes/ts2kt.js"
        kotlinOptions.sourceMap = true
        dependsOn(extractJsLibs)
    }
    val compileTestKotlin2Js by getting(Kotlin2JsCompile::class) {
        kotlinOptions.moduleKind = "commonjs"
        kotlinOptions.outputFile = "$projectDir/out/test/classes/ts2kt_test.js"
        kotlinOptions.sourceMap = true
        dependsOn(extractTestJsLibs)
    }

    /**** Unit tests. ****/
    val populateNodeModules by creating(Copy::class) {
        dependsOn(compileKotlin2Js)
        from("$projectDir/out/production/classes") { include("*.js") }
        configurations["testCompile"].forEach {
            from(zipTree(it.absolutePath).matching { include("*.js") })
        }
        into("$projectDir/node_modules")
    }
    val npmModules = arrayOf("jest")
    val installTestNpmModules = task<NpmTask>("installTestNpmModules") {
        setNpmCommand("install", *npmModules)
    }
    val runJest = task<NodeTask>("runJest") {
        dependsOn(compileTestKotlin2Js, populateNodeModules)
        if (npmModules.any { !file("$projectDir/node_modules/$it").exists() }) {
            dependsOn(installTestNpmModules)
        }
        setScript(file("$projectDir/node_modules/jest/bin/jest.js"))
        addArgs(compileTestKotlin2Js.outputFile)
    }
    "test" {
        dependsOn(runJest)
    }
    /**** End Unit tests. ****/
}

configure<NodeExtension> {
    download = true
}
