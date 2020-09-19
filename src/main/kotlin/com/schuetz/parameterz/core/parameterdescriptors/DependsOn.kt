package com.schuetz.parameterz.core.parameterdescriptors

abstract class DependsOn(val type: Type) {

    class AndDependsOn(val dependencies: Collection<DependsOn>) : DependsOn(Type.AND)
    class OrDependsOn(val dependencies: Collection<DependsOn>) : DependsOn(Type.OR)
    class NotDependsOn(val parameter: String, val value: String) : DependsOn(Type.NOT)
    class JustDependsOn(val parameter: String, val value: String) : DependsOn(Type.JUST)

    companion object {
        fun not(parameter: String, value: String): DependsOn {
            return DependsOn.NotDependsOn(parameter, value)
        }

        fun just(parameter: String, value: String): DependsOn {
            return DependsOn.JustDependsOn(parameter, value)
        }

        fun and(vararg deps: DependsOn): DependsOn {
            return DependsOn.AndDependsOn(deps.toList())
        }

        fun or(vararg deps: DependsOn): DependsOn {
            return DependsOn.OrDependsOn(deps.toList())
        }
    }

    enum class Type {
        AND, OR, NOT, JUST
    }
}
