package com.schuetz.parameterz.core.parameterdescriptors.translation

interface TranslationProvider<T : TranslationKey<T>> {
    fun getTranslation(translationKey: T, language: String): String
}