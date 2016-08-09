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
using installed node.js:
  ```shell
  npm install
  ```
  
without install node.js:
  ```shell
  ant -f build.xml update.tools
  ant -f build.xml update.node.modules
  ```

4. setup path to node interpreter in IDEA (Languages & Frameworks | Node.js and NPM)

###### How to update submodules
  ```shell
  git submodule update --remote
  ```

# Useful links
[TypeScript type definitions](https://github.com/DefinitelyTyped/DefinitelyTyped)
[About git submodules](https://git-scm.com/book/en/v2/Git-Tools-Submodules)
