package com.schuetz.parameterz.core.parameterdescriptors

import com.schuetz.parameterz.core.parameterdescriptors.foundation.exceptions.NoSuitableBuilderException
import com.schuetz.parameterz.core.parameterdescriptors.translation.ParameterTranslatorService

class ParameterBuilderService(
    private val translatorService: ParameterTranslatorService?,
    private val builders: Map<Class<*>, ParameterBuilder<*>>
) {

    fun constructParameters(obj: Any): List<Parameter> {
        val type = obj::class.java
        val builder = builders.getOrElse(type) { throw NoSuitableBuilderException(type) }

        val parameters = builder.constructParametersInternal(obj)

        if (translatorService != null) {
            return parameters.map(::translate)
        }

        return parameters.sortedWith(builder.provideComparator())
    }

    private fun translate(param: Parameter): Parameter {
        return translatorService!!.translate(param)
    }

    @Suppress("UNCHECKED_CAST")
    private fun ParameterBuilder<*>.constructParametersInternal(obj: Any): List<Parameter> {
        return (this as ParameterBuilder<Any>).constructParameters(obj)
    }
}
