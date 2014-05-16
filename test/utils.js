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

var WORKING_DIR = "../compiled/";
var ts2kt = require(WORKING_DIR + "ts2kt");
var fs = require('fs');

var DTS_EXT = ".d.ts";
var KT_EXT = ".kt";


function replaceExtension(path, expected, replacment) {
    if (path.endsWith(expected)) {
        return path.substr(0, path.length - expected.length) + replacment;
    }

    return path;
}

function collectSingleFile (testFile, tests, testDataDir, testDataExpectedDir) {
    testDataDir = testDataDir || "";
    testDataExpectedDir = testDataExpectedDir || testDataDir;

    var expectedFile = replaceExtension(testFile, DTS_EXT, KT_EXT);
    tests[testFile] = generateTestFor(testDataDir + "/" + testFile, testDataExpectedDir + "/" + expectedFile);
}

function collectTestFiles(dir, tests, testDataExpectedDir, testDataDir) {
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
                collectTestFiles(path, tests[file] = {}, testDataExpectedDir, testDataDir);
            }
            else {
                if (file.endsWith(".d.ts")) {
                    var expectedFilePath = replaceExtension(path.substr(testDataDir.length), DTS_EXT, KT_EXT);
                    tests[file] = generateTestFor(path, testDataExpectedDir + expectedFilePath);
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

function generateTestFor(srcPath, expectedPath) {
    return function(test) {
        var outPath = expectedPath + ".out";

        createDirsIfNeed(outPath);

        ts2kt.translateToFile(srcPath, outPath);

//        test.done();
//        return;

        var actual = fs.readFileSync(outPath, {encoding: "utf8"});

        if (!fs.existsSync(expectedPath)) {
            fs.writeFileSync(expectedPath, "// OUT:\n");
            fs.appendFileSync(expectedPath, actual);
        }

        var expected = fs.readFileSync(expectedPath, {encoding: "utf8"});

        test.equals(actual,  expected);
        test.done()
    }
}

exports.collectTestFiles = collectTestFiles;
exports.collectSingleFile = collectSingleFile;
