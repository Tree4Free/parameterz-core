package com.schuetz.parameterz.core.parameterdescriptors.spring

import com.schuetz.parameterz.core.parameterdescriptors.translation.ParameterTranslatorService
import com.schuetz.parameterz.core.parameterdescriptors.translation.TranslationLanguageSource
import com.schuetz.parameterz.core.parameterdescriptors.translation.TranslationProvider
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class ParameterTranslatorConfig {

    @Bean
    fun createParameterTranslatorService(languageSource: TranslationLanguageSource, translationProvider: TranslationProvider): ParameterTranslatorService {
        return ParameterTranslatorService(
            translationProvider = translationProvider,
            translationLanguageSource = languageSource
        )
    }
}