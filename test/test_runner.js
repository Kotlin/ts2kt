var assert = require('chai').assert;

function addTestSuites(testData) {
  for (let [key, testCase] of Object.entries(testData)) {
    if (typeof testCase == "function") {
      it(key, testData[key]);
    } else if (typeof testCase == "object") {
      addTestSuites(testCase);
    }
  }
}

describe("short: check nodejs version", function() {
  const version  = "v11.1.0";

  if (process.version !== version) {
    console.warn(`supposed to be used with node ${version} (was used with ${process.version})`)
  }
})

describe("short: testData tests", function() {
  addTestSuites(require("./tests/testData"));
});

describe("long: testDefinitelyTyped tests", function() {
  addTestSuites(require("./tests/testDefinitelyTyped"));
});