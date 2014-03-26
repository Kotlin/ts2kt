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

//package kotlinAst
//
//trait Node {
//    fun accept(visitor: Visitor)
//}
//
////class Module(val name: String) : Node {
////    override fun accept(visitor: Visitor) {
////        visitor.visitModule(this)
////    }
////}
//
////class Annotation(val name: String) : Node {
////    override fun accept(visitor: Visitor) {
////        visitor.visitPackage(this)
////    }
////}
//
//class Package(val name: String) : Node {
//    override fun accept(visitor: Visitor) {
//        visitor.visitPackage(this)
//    }
//}
//
//class Trait(val name: String) : Node {
//    override fun accept(visitor: Visitor) {
//        visitor.visitTrait(this)
//    }
//}
//
//class Class(val name: String) : Node {
//    override fun accept(visitor: Visitor) {
//        visitor.visitClass(this)
//    }
//}
//
//class Object(val name: String) : Node {
//    override fun accept(visitor: Visitor) {
//        visitor.visitObject(this)
//    }
//}
//
//class Function(val name: String) : Node {
//    override fun accept(visitor: Visitor) {
//        visitor.visitFunction(this)
//    }
//}
//
//class Property(val name: String) : Node {
//    override fun accept(visitor: Visitor) {
//        visitor.visitProperty(this)
//    }
//}
//
//class Type(val name: String) : Node {
//    override fun accept(visitor: Visitor) {
//        visitor.visitType(this)
//    }
//}
//
//class Value(val name: String) : Node {
//    override fun accept(visitor: Visitor) {
//        visitor.visitValue(this)
//    }
//}
//
//trait Visitor {
//    fun visitNode(node: Node)
//    fun visitPackage(node: Package)
//    fun visitTrait(node: Trait)
//    fun visitClass(node: Class)
//    fun visitObject(node: Object)
//    fun visitFunction(node: Function)
//    fun visitProperty(node: Property)
//    fun visitType(node: Type)
//    fun visitValue(node: Value)
//}
