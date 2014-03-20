var ts2kt = require("../out/production/ts2kt/ts2kt")

var fs = require('fs');

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

var walk = function(dir, exports) {

    var list = fs.readdirSync(dir);

    for (var i = 0; i < list.length; i++) {
        var file = list[i];

        function process(dir, file) {
            if (file === "out") return;

            var path = dir + '/' + file;
            var stat = fs.statSync(path);
            if (stat && stat.isDirectory()) {
                walk(path, exports[file] = {});
            }
            else {
                if (file.indexOf(".d.ts", file.length - 5) != -1) {
                    exports[file] = generateTestFor(path);
                }
            }
        }


        process(dir, file);
    }
};

//walk("testData", exports);
exports["0"] = generateTestFor("testData/topLevelMembers.d.ts");