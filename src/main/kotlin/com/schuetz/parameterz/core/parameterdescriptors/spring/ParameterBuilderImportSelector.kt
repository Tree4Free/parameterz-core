package com.schuetz.parameterz.core.parameterdescriptors.spring

import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.ImportSelector
import org.springframework.core.type.AnnotationMetadata

@Configuration
class ParameterBuilderImportSelector : ImportSelector {
    override fun selectImports(importingClassMetadata: AnnotationMetadata): Array<String> {
        val imports = mutableListOf<String>()

        if (importingClassMetadata.hasAnnotation(EnableParameterBuilder::class.java.name)) {
            imports += ParameterBuilderConfig::class.java.name

            val attributes = importingClassMetadata.getAnnotationAttributes(EnableParameterBuilder::class.java.name)

            if (attributes != null && attributes[enableTranslationsKey] == true) {
                imports += ParameterTranslatorConfig::class.java.name
            }
        }

        return imports.toTypedArray()
    }

    companion object {
        private const val enableTranslationsKey = "enableTranslations"
    }
}