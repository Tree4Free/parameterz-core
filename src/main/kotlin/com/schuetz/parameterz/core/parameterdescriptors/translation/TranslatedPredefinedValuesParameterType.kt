package com.schuetz.parameterz.core.parameterdescriptors.translation

import com.schuetz.parameterz.core.parameterdescriptors.type.ParameterType
import com.schuetz.parameterz.core.parameterdescriptors.type.PredefinedParameterType

class TranslatedPredefinedValuesParameterType(val translatedValues: Map<String, String>, val parameterType: PredefinedParameterType) : ParameterType {
    override val type: String = "TRANSLATED_PREDEFINED"
}
