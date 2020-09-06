package com.schuetz.parameterz.core.parameterdescriptors.validation

class RegexValidation(val regex: String) : Validation {
    override val type: String = TYPE

    companion object {
        const val TYPE: String = "REGEX"
    }
}
