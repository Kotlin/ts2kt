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

        var expected = fs.readFileSync(expectedPath, {encoding: "utf8"});
        var actual = fs.readFileSync(outPath, {encoding: "utf8"});

        test.equals(actual,  expected);
        test.done()
    }
}
