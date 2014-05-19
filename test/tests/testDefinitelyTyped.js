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

var utils = require('./../utils');

var TEST_DATA_DIR = "testDefinitelyTyped/DefinitelyTyped";
var TEST_DATA_EXPECTED_DIR = "testDefinitelyTyped/expected";

var NEEDS_ONLY_RUN = true;

//var fileToTest = "../../" +
//    "testDefinitelyTyped/DefinitelyTyped/hellojs/hellojs.d.ts";

var tests = exports;

if (typeof fileToTest === "string" && fileToTest) {
    utils.collectSingleFile(fileToTest, tests, TEST_DATA_DIR, TEST_DATA_EXPECTED_DIR, NEEDS_ONLY_RUN);
    tests = tests["other"] = {};
}

utils.collectTestFiles(TEST_DATA_DIR, tests, TEST_DATA_EXPECTED_DIR, NEEDS_ONLY_RUN);
