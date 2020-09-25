package com.schuetz.parameterz.core.parameterdescriptors.spring

import com.schuetz.parameterz.core.parameterdescriptors.ParameterBuilder
import com.schuetz.parameterz.core.parameterdescriptors.ParameterBuilderService
import com.schuetz.parameterz.core.parameterdescriptors.translation.ParameterTranslatorService
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.GenericTypeResolver

@Configuration
class ParameterBuilderConfig {

    @Bean
    fun createParameterBuilderService(translatorService: ParameterTranslatorService<*>?, builders: Collection<ParameterBuilder<*>>): ParameterBuilderService {
        return ParameterBuilderService(
            translatorService = translatorService,
            builders = builders.associateBy { GenericTypeResolver.resolveTypeArgument(it::class.java, ParameterBuilder::class.java)!! }
        )
    }
}