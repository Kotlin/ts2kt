/*
 * Copyright 2013-2014 JetBrains s.r.o.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

var WORKING_DIR = "../out/production/ts2kt/";
var ts2kt = require(WORKING_DIR + "ts2kt");
var fs = require('fs');
var assert = require('assert');

var TS_EXT = ".ts";
var KT_EXT = ".kt";

var UNVERIFIED_FILE_PREFIX = "// OUT:";

var OPERATION_LEVEL = {
    NONE: 0,
    CONVERT: 1,
    CHECK: 2
};

function getTestConfigBasedOnEnvironment() {
    return {
        verified: process.env.VERIFIED_OPERATION_LEVEL || OPERATION_LEVEL.CHECK,
        other: process.env.OTHER_OPERATION_LEVEL || OPERATION_LEVEL.CONVERT
    };
}

function replaceExtension(path, expected, replacment) {
    if (path.endsWith(expected)) {
        return path.substr(0, path.length - expected.length) + replacment;
    }

    return path;
}

function collectSingleFile (testFile, tests, testDataDir, testDataExpectedDir) {
    testDataDir = testDataDir || "";
    testDataExpectedDir = testDataExpectedDir || testDataDir;

    var testConfig = getTestConfigBasedOnEnvironment();

    var expectedFile = replaceExtension(testFile, TS_EXT, KT_EXT);
    addTestFor(tests, testFile, testDataDir + "/" + testFile, testDataExpectedDir + "/" + expectedFile, testConfig);
}

function collectTestFiles(dir, tests, testDataExpectedDir, testDataDir) {
    var testConfig = getTestConfigBasedOnEnvironment();
    return collectTestFilesRec(dir, tests, testDataExpectedDir, testConfig, testDataDir)
}

function collectTestFilesRec(dir, tests, testDataExpectedDir, testConfig, testDataDir) {
    testDataExpectedDir = testDataExpectedDir || dir;
    testDataDir = testDataDir || dir;

    var list = fs.readdirSync(dir);

    for (var i = 0; i < list.length; i++) {
        var file = list[i];

        function process(dir, file) {
            if (file === "out") return;
            if (file === "_infrastructure") return;

            var path = dir + '/' + file;
            var stat = fs.statSync(path);
            if (stat && stat.isDirectory()) {
                collectTestFilesRec(path, tests[file] = {}, testDataExpectedDir, testConfig, testDataDir);
            }
            else {
                if (file.endsWith(".d.ts")) {
                    var expectedFilePath = replaceExtension(path.substr(testDataDir.length), TS_EXT, KT_EXT);
                    addTestFor(tests, file, path, testDataExpectedDir + expectedFilePath, testConfig);
                }
            }
        }


        process(dir, file);
    }
}

function createDirsIfNeed(path) {
    var dirs = path.split("/").slice(0, -1);
    var dirCount = dirs.length;
    var cur = ".";
    for (var i = 0; i < dirCount; i++) {
        var dir = dirs[i];
        cur += "/" + dir;
        if (!fs.existsSync(cur)) {
            fs.mkdirSync(cur)
        }
    }
}

function addTestFor(tests, testName, srcPath, expectedPath, testConfig) {
    var testFun = generateTestFor(srcPath, expectedPath, testConfig);
    if (testFun) tests[testName] = testFun;
}

function generateTestFor(srcPath, expectedPath, testConfig) {
    var expected;

    if (fs.existsSync(expectedPath)) {
        expected = fs.readFileSync(expectedPath, {encoding: "utf8"});
        expected = expected.replace(/\n\s*\/\/\s*TODO[^\n]*/g, "").replace(/\r\n/g, "\n");
    }

    var isVerified = expected && !expected.startsWith(UNVERIFIED_FILE_PREFIX);

    if (isVerified && testConfig.verified < OPERATION_LEVEL.CONVERT || !isVerified && testConfig.other < OPERATION_LEVEL.CONVERT) {
        return
    }

    return function(test) {
        var outPath = expectedPath + ".out";

        createDirsIfNeed(outPath);

        console.log("\n--------\nsrcPath = " + srcPath +
                    ", outPath = " + outPath +
                    ", expectedPath = " + expectedPath +
                    ", testConfig = " + testConfig.verified + testConfig.other + "\n");

        ts2kt.translateToFile_puj7f4$(srcPath, outPath);

        var actual = fs.readFileSync(outPath, {encoding: "utf8"});

        if (!fs.existsSync(expectedPath)) {
            expected = UNVERIFIED_FILE_PREFIX + "\n" + actual;
            fs.writeFileSync(expectedPath, expected);
        }

        if (isVerified && testConfig.verified >= OPERATION_LEVEL.CHECK || !isVerified && testConfig.other >= OPERATION_LEVEL.CHECK) {
            try {
                assert.equal(actual, expected);
            }
            catch (e) {
                e.expectedFilePath = fs.realpathSync(expectedPath);
                e.actualFilePath = fs.realpathSync(outPath);
                throw e;
            }
        }

        test.done();
    }
}

exports.collectTestFiles = collectTestFiles;
exports.collectSingleFile = collectSingleFile;
