package com.schuetz.parameterz.core.parameterdescriptors.translation

import com.schuetz.parameterz.core.parameterdescriptors.DependsOn
import com.schuetz.parameterz.core.parameterdescriptors.Parameter
import com.schuetz.parameterz.core.parameterdescriptors.type.ParameterType
import com.schuetz.parameterz.core.parameterdescriptors.validation.Validation

class TranslatedParameter(
    name: String,
    translationKey: String,
    val displayName: String,
    val description: String,
    order: Int,
    type: ParameterType,
    validation: Collection<Validation>,
    defaultValue: String,
    dependsOn: DependsOn?,
    required: Boolean,
    additionalProperties: Map<String, Any>
) : Parameter(name, translationKey, order, type, validation, defaultValue, dependsOn, required, additionalProperties)
