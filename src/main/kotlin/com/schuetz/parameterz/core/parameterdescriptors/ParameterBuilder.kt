package com.schuetz.parameterz.core.parameterdescriptors

interface ParameterBuilder<T : Any> {
    fun constructParameters(obj: T): List<Parameter>

    fun provideComparator(): Comparator<Parameter> {
        return compareBy<Parameter> { it.order }
    }
}

