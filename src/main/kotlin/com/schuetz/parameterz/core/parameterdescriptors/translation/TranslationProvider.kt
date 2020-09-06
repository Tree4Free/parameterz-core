package com.schuetz.parameterz.core.parameterdescriptors.translation

/**
 * Format:
 * - Description: {translationKey}_description
 * - Display name: {translationKey}_name
 * - Predefined value (eg: Enum value): {translationKey}_values_{value}
 */
interface TranslationProvider {
    fun getTranslation(translationKey: String, language: String): String
}