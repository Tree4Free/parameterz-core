package com.schuetz.parameterz.core.parameterdescriptors.validation

class MinMaxValidation(val min: Long? = null, val max: Long? = null) : Validation {
    override val type: String = TYPE

    companion object {
        const val TYPE: String = "MIN-MAX"
    }
}
