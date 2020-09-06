package com.schuetz.parameterz.core.parameterdescriptors.spring

import org.springframework.context.annotation.Import

@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.CLASS)
@Import(ParameterBuilderImportSelector::class)
annotation class EnableParameterBuilder(
    val enableTranslations: Boolean
)

