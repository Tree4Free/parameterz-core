package com.schuetz.parameterz.core.parameterdescriptors.translation

import com.schuetz.parameterz.core.parameterdescriptors.Parameter
import com.schuetz.parameterz.core.parameterdescriptors.type.ParameterType
import com.schuetz.parameterz.core.parameterdescriptors.type.PredefinedParameterType
import org.slf4j.LoggerFactory

class ParameterTranslatorService(
    private val translationProvider: TranslationProvider,
    private val translationLanguageSource: TranslationLanguageSource
) {

    private val log = LoggerFactory.getLogger(ParameterTranslatorService::class.java)

    fun translate(parameter: Parameter): Parameter {
        val lang = translationLanguageSource.getLanguage()

        if (lang == null) {
            log.warn("No language provided. Skipping translation.")
            return parameter
        }

        return TranslatedParameter(
            order = parameter.order,
            name = parameter.name,
            translationKey = parameter.translationKey,
            defaultValue = parameter.defaultValue,
            dependsOn = parameter.dependsOn,
            validation = parameter.validation,
            required = parameter.required,
            description = translationProvider.getTranslation(parameter.translationKey + DESCRIPTION_POSTFIX, lang),
            displayName = translationProvider.getTranslation(parameter.translationKey + NAME_POSTFIX, lang),
            type = if (parameter.type is PredefinedParameterType) translateParameterType(parameter.translationKey, parameter.type, lang) else parameter.type,
            additionalProperties = parameter.additionalProperties
        )
    }

    private fun translateParameterType(translationKey: String, type: PredefinedParameterType, lang: String): ParameterType {
        return TranslatedPredefinedValuesParameterType(
            parameterType = type,
            translatedValues = type.values.associateWith {
                translationProvider.getTranslation(translationKey + "_values_" + it, lang)
            }
        )
    }

    companion object {
        const val DESCRIPTION_POSTFIX = "_description"
        const val NAME_POSTFIX = "_name"
    }
}
