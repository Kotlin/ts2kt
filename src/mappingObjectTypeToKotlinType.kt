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

package ts2kt

import java.util.HashMap
import ts2kt.utils.replaceAll
import ts2kt.utils.sort
import ts2kt.kotlin.ast.*
import ts2kt.kotlin.ast
import typescript.*

trait ObjectTypeToKotlinTypeMapper {
    fun getKotlinTypeNameForObjectType(objectType: TS.TypeLiteralNode): String
}

class ObjectTypeToKotlinTypeMapperImpl(
        val defaultAnnotations: List<ast.Annotation>,
        val declarations: MutableList<Member>
) : ObjectTypeToKotlinTypeMapper {

    companion object {
        private var n = 0

        fun reset() {
            n = 0
        }
    }

    val cache = HashMap<String, String>()

    init {
        // TODO better declaration for known classes
        cache[""] = "Any"

        val jsonTypeKey = "nativeGetter\npublic fun get(String): Any, nativeSetter\npublic fun set(String, Any)";
        cache[jsonTypeKey] = "Json"
    }

    override fun getKotlinTypeNameForObjectType(objectType: TS.TypeLiteralNode): String {
        val translator = TsInterfaceToKt(annotations = defaultAnnotations, typeMapper = this, isOverride = NOT_OVERRIDE, isOverrideProperty = NOT_OVERRIDE)

        forEachChild(translator, objectType)

        val typeKey = translator.declarations.toStringKey()

        val cachedTraitName = cache[typeKey]
        if (cachedTraitName != null) return cachedTraitName

        val traitName = "T$${n++}"
        translator.name = traitName

        declarations.add(translator.result)

        cache[typeKey] = traitName
        return traitName
    }

    fun <T> List<T>.toStringKey(): String =
            map { it.toString().replaceAll("(\\(|,\\s*)\\w+: ", "$1") }.copyToArray().sort().join(", ")
}
