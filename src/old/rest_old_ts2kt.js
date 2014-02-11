function appendNewLineIfNeed() {
  if (kt[kt.length - 1] != "{") {
    kt += "\n"
  }
}
function processModuleTree(moduleTree, indent) {
  for (var moduleName in moduleTree) {
    appendNewLineIfNeed()
    kt += "\n" + indent + "public object " + moduleName + " {"
    var subModuleTree = Object.create(null)
    var subIndent = indent + "\t";
    var subModules = moduleTree[moduleName];
    for (var i = 0, n = subModules.length; i < n; i++) {
      processMembers(subModules[i], subModuleTree, subIndent)
    }
    processModuleTree(subModuleTree, subIndent)
    kt += "\n" + indent + "}"
  }
}

function processFunction(member, indent) {
  if (indent !== null) {
    kt += "\n" + indent + "public "
    if (member.isDeclaration() || TypeScript.hasFlag(member.fncFlags, TypeScript.FncFlags.IsFunctionExpression)) {
      kt += "fun"
    }
    else {
      kt += "var"
    }
    kt += " " + member.name.text
    if (member.name.text == "change") {
      //debugger
    }
  }
  kt += "("
  var args = member.arguments.members
  var isFirst = true
  for (var i = 0, n = args.length; i < n; i++) {
    var arg = args[i];
    if (arg.nodeType != TypeScript.NodeType.ArgDecl) {
      console.log("skip unsupported arg node " + arg)
      continue
    }

    if (isFirst) {
      isFirst = false
    }
    else {
      kt += ", "
    }

    if (i == (n - 1) && member.variableArgList) {
      kt += "vararg "
    }

    kt += arg.id.text + ": "
    if (arg.typeExpr == null) {
      kt += "Any"
      continue;
    }
    processExpression(arg.typeExpr.term)
    if (arg.isOptionalArg()) {
      kt += "? = null"
    }
  }
  kt += "):"
  if (member.returnTypeAnnotation === null) {
    kt += "Unit"
  }
  else {
    processExpression(member.returnTypeAnnotation.term)
  }
}

function processExpression(expression) {
  switch (expression.nodeType) {
    case TypeScript.NodeType.Dot:
      processExpression(expression.operand1)
      kt += "."
      processExpression(expression.operand2)
      break

    case TypeScript.NodeType.Name:
      kt += tsTypeNameToKotlin(expression.text)
      break

    case TypeScript.NodeType.FuncDecl:
      processFunction(expression, null)
      break

    case TypeScript.NodeType.InterfaceDeclaration:
      // todo ObservableObject.toJSON(): { [key: string]: any; };
      kt += "Any"
      break

    default:
      debugger
      throw new Error("Unsupported node " + expression.nodeType)
  }
}

function processMembers(members, moduleTree, indent) {
  for (var i = 0, n = members.length; i < n; i++) {
    var member = members[i]

    // d.ts can contains duplicated class/interface, so, we merge it
    var traitNameToMembers = Object.create(null)
    var classNameToMembers = Object.create(null)
    switch (member.nodeType) {
      case TypeScript.NodeType.FuncDecl:
        if (!member.isConstructor) {
          processFunction(member, indent)
        }
        break;

      case TypeScript.NodeType.InterfaceDeclaration:
        addOrCreate(traitNameToMembers, member.name.text, member.members.members)
        break;

      case TypeScript.NodeType.ClassDeclaration:
        addOrCreate(classNameToMembers, member.name.text, member.members.members)
        break;

      case TypeScript.NodeType.ModuleDeclaration:
        assert(moduleTree !== null)
        var name = member.name.text
        // collect modules, d.ts can contains "module kendo, module kendo.data", but in Kotlin it will be "object kendo {object data{}}"
        // so, we cannot print module memebers rignt now
        addOrCreate(moduleTree, name, member.members.members)
        break;

      case TypeScript.NodeType.VarDecl:
        processVariable(member, indent)
        break;

      default:
        console.log("skip " + (member.name === undefined ? "" : member.name.text) + ", unsupported node type " + member.nodeType)
    }

    processClassesOrTraits(traitNameToMembers, indent, true)
    processClassesOrTraits(classNameToMembers, indent, false)
  }
}

function processVariable(member, indent) {
  kt += "\n" + indent + "public "
  var term = member.typeExpr.term;
  // is it object declaration (kotlin singleton)
  var isObjectDeclaration = term.nodeType == TypeScript.NodeType.Interface
  if (isObjectDeclaration) {
    kt += "object "
  }
  else {
    //if (member.id.text == "paramName") {
    //  debugger
    //}
    kt += "val "
  }
  kt += member.id.text
  if (isObjectDeclaration) {
    kt += " {"
    processMembers(term.members.members, null, indent + "\t")
    kt += "\n" + indent + "}"
  }
  else {
    kt += ":"
    processExpression(term)
    if (TypeScript.hasFlag(member.sym.flags, TypeScript.SymbolFlags.Optional)) {
      kt += "?"
    }
  }
}

function processClassesOrTraits(map, indent, isTrait) {
  for (var name in map) {
    appendNewLineIfNeed()
    kt += "\n" + indent + "public " + (isTrait ? "trait" : "class") + " " + name
    var subIndent = indent + "\t";
    var subMembers = map[name];
    var hasMembers = subMembers.length > 0 && subMembers[0].length > 0;
    if (hasMembers) {
      var firstMember = subMembers[0][0];
      if (firstMember.nodeType === TypeScript.NodeType.FuncDecl && firstMember.isConstructor) {
        processFunction(firstMember, null)
      }
      kt += " {"
    }
    for (var i = 0, n = subMembers.length; i < n; i++) {
      processMembers(subMembers[i], null, subIndent)
    }

    if (hasMembers) {
      kt += "\n" + indent + "}"
    }
  }
}

function addOrCreate(map, name, item) {
  var list = map[name]
  if (list === undefined) {
    map[name] = [item]
  }
  else {
    map[name].push(item)
  }
}
