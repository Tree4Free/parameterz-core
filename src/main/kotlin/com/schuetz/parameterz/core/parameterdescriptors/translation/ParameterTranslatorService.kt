package com.schuetz.parameterz.core.parameterdescriptors.translation

import com.schuetz.parameterz.core.parameterdescriptors.Parameter
import com.schuetz.parameterz.core.parameterdescriptors.type.ParameterType
import com.schuetz.parameterz.core.parameterdescriptors.type.PredefinedParameterType
import org.slf4j.LoggerFactory

class ParameterTranslatorService<T : TranslationKey<T>>(
    private val translationProvider: TranslationProvider<T>,
    private val translationLanguageSource: TranslationLanguageSource
) {

    private val log = LoggerFactory.getLogger(ParameterTranslatorService::class.java)

    fun translate(parameter: Parameter): Parameter {
        val lang = translationLanguageSource.getLanguage()

        when {
            lang == null -> return parameter.also { log.warn("No language provided. Skipping translation.") }
            parameter.translationKey == null -> return parameter.also { log.warn("No translation key provided. Skipping translation.") }
        }

        return TranslatedParameter(
            order = parameter.order,
            name = parameter.name,
            translationKey = parameter.translationKey!!,
            defaultValue = parameter.defaultValue,
            dependsOn = parameter.dependsOn,
            validation = parameter.validation,
            required = parameter.required,
            description = translationProvider.getTranslation(parameter.translationKey.description() as T, lang!!),
            displayName = translationProvider.getTranslation(parameter.translationKey.name() as T, lang),
            type = if (parameter.type is PredefinedParameterType) translateParameterType(parameter.translationKey, parameter.type, lang) else parameter.type,
            additionalProperties = parameter.additionalProperties
        )
    }

    private fun translateParameterType(translationKey: TranslationKey<*>, type: PredefinedParameterType, lang: String): ParameterType {
        return TranslatedPredefinedValuesParameterType(
            parameterType = type,
            translatedValues = type.values.associateWith {
                translationProvider.getTranslation(translationKey.value(it) as T, lang)
            }
        )
    }
}
