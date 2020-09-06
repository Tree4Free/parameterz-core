package com.schuetz.parameterz.core.parameterdescriptors.validation

class LengthValidation(val minLength: Long? = null, val maxLength: Long? = null) : Validation {
    override val type: String = TYPE

    companion object {
        const val TYPE: String = "LENGTH"
    }
}
