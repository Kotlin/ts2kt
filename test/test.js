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

var TEST_DATA_DIR = "testData";
var fileToTest = "";

var tests = exports;

if (typeof fileToTest === "string" && fileToTest) {
    collectSingleFile(fileToTest, tests);
    tests = tests["other"] = {};
}

collectTestFiles(TEST_DATA_DIR, tests);

// Helpers

function collectSingleFile (testFile, tests) {
    tests[testFile] = generateTestFor(TEST_DATA_DIR + "/" + testFile);
}

function collectTestFiles(dir, tests) {

    var list = fs.readdirSync(dir);

    for (var i = 0; i < list.length; i++) {
        var file = list[i];

        function process(dir, file) {
            if (file === "out") return;

            var path = dir + '/' + file;
            var stat = fs.statSync(path);
            if (stat && stat.isDirectory()) {
                collectTestFiles(path, tests[file] = {});
            }
            else {
                if (file.indexOf(".d.ts", file.length - 5) != -1) {
                    tests[file] = generateTestFor(path);
                }
            }
        }


        process(dir, file);
    }
}

function generateTestFor(srcPath) {
    return function(test) {
        var expectedPath = srcPath.substr(0, srcPath.length - 5) + ".kt";
        var outPath = expectedPath + ".out";

        ts2kt.translateToFile(srcPath, outPath);

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
