package ts2kt

import node.EncodingOptions
import node.fs
import kotlin.test.Test
import kotlin.test.assertEquals

class RunnerTest {
    val TS_EXT = ".ts"
    val KT_EXT = ".kt"
    val UNVERIFIED_FILE_PREFIX = "// OUT:"

    @Test
    fun translateToFile() {
        translateAndVerifyDirectory("testData")
    }

    private fun translateAndVerifyDirectory(path: String) {
        console.info("Looking in $path")
        fs.readdirSync(path).forEach { file ->
            if (file.endsWith(".ts")) {
                translateToFileAndVerify(path + "/" + file)
            } else if (!file.contains(".")) {
                translateAndVerifyDirectory(path + "/" + file)
            }
        }
    }

    fun translateToFileAndVerify(srcPath: String, expectedPath: String = srcPath.replace(TS_EXT, KT_EXT)) {
        val outPath = expectedPath + ".out"
        console.log("\n--------\nsrcPath = " + srcPath +
                ", outPath = " + outPath +
                ", expectedPath = " + expectedPath + "\n")
        translateToFile(srcPath, outPath)
        val encodingOptions = EncodingOptions(encoding = "utf8")
        val actual = fs.readFileSync(outPath, encodingOptions)

        val expected: String?
        if (!fs.existsSync(expectedPath)) {
            expected = UNVERIFIED_FILE_PREFIX + "\n" + actual
            fs.writeFileSync(expectedPath, expected)
        } else {
            expected = fs.readFileSync(expectedPath, encodingOptions)
        }
        assertEquals(expected, actual, "expectedPath: $expectedPath, outPath=$outPath")
    }
}
