# Description
Converter of TypeScript definition files to Kotlin declarations (stubs)

# How to setup project
1. clone this project
  ```shell
  git clone <this project url>
  ```

2. get submodules (https://github.com/DefinitelyTyped/DefinitelyTyped)
  ```shell
  git submodule init
  git submodule update
  ```

3. install dependencies
  * using installed node.js:
  
  ```shell
  npm install
  ```
  
  * without installing node.js:

  ```shell
  ant -f build.xml update.tools
  ant -f build.xml update.node.modules
  ```

4. setup path to node interpreter in IDEA (Languages & Frameworks | Node.js and NPM)

5. Convert the tool to Javascript.  One way is to open the project in IntelliJ and build the project (e.g. Ctrl+Shift+F9).

6. Run the tool in one of these ways:
  * Run it with node.js (Note: the root of the project should be working dir):

    ```shell
    node out/production/ts2kt/ts2kt.js path/to/input.d.ts path/to/output.kt
    ```
  * Directly call translateToFile_puj7f4$ from JS (translateToFile in code).
  * Create run configuration like shared jq and run it.


###### How to update submodules
  ```shell
  git submodule update --remote
  ```

# Useful links
[TypeScript type definitions](https://github.com/DefinitelyTyped/DefinitelyTyped)
[About git submodules](https://git-scm.com/book/en/v2/Git-Tools-Submodules)
