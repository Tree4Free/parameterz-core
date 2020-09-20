package com.schuetz.parameterz.core.parameterdescriptors

import com.schuetz.parameterz.core.parameterdescriptors.type.ParameterType
import com.schuetz.parameterz.core.parameterdescriptors.validation.Validation

open class Parameter(
    val name: String,
    val translationKey: String,
    val order: Int,
    val type: ParameterType,
    val validation: Collection<Validation>,
    val defaultValue: String,
    val dependsOn: _root_ide_package_.com.schuetz.parameterz.core.parameterdescriptors.DependsOn?,
    val required: Boolean,
    val additionalProperties: Map<String, Any>
)
