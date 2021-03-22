package com.schuetz.parameterz.core.parameterdescriptors.type

object ParameterTypes {
    class ENTITY<Entity : ENTITY.EntityDescriptor>(override val multiple: Boolean, val entity: Entity) : ListableParameterType {
        override val type: String = "ENTITY"

        interface EntityDescriptor {
            val type: String
        }
    }

    val STRING = object : ParameterType {
        override val type: String = "STRING"
    }

    val SECRET = object : ParameterType {
        override val type: String = "SECRET"
    }

    val BOOLEAN = object : ParameterType {
        override val type: String = "BOOLEAN"
    }

    class NUMBER(override val multiple: Boolean, val floatingPoint: Boolean) : ListableParameterType {
        override val type: String = "NUMBER"
    }

    class ENUM(
        override val multiple: Boolean,
        val enumType: Class<out Enum<*>>,
        override val translate: Boolean
    ) : ListableParameterType, PredefinedParameterType {
        override val type: String = "ENUM"

        override val values = enumType.enumConstants.map { it.name }
    }
}
