package com.schuetz.parameterz.core.parameterdescriptors.translation

interface TranslationKey<T : TranslationKey<T>> {
    fun description(): T
    fun name(): T
    fun value(value: String): T

    fun asString(): String

    companion object {
        const val DESCRIPTION_SUFFIX = "_description"
        const val NAME_SUFFIX = "_name"
        const val VALUE_SUFFIX = "_values_"
    }
}
