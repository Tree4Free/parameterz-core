package com.schuetz.parameterz.core.parameterdescriptors

abstract class DependsOn(val type: _root_ide_package_.com.schuetz.parameterz.core.parameterdescriptors.DependsOn.Type) {

    class AndDependsOn(val dependencies: Collection<_root_ide_package_.com.schuetz.parameterz.core.parameterdescriptors.DependsOn>) : _root_ide_package_.com.schuetz.parameterz.core.parameterdescriptors.DependsOn(_root_ide_package_.com.schuetz.parameterz.core.parameterdescriptors.DependsOn.Type.AND)
    class OrDependsOn(val dependencies: Collection<_root_ide_package_.com.schuetz.parameterz.core.parameterdescriptors.DependsOn>) : _root_ide_package_.com.schuetz.parameterz.core.parameterdescriptors.DependsOn(_root_ide_package_.com.schuetz.parameterz.core.parameterdescriptors.DependsOn.Type.OR)
    class NotDependsOn(val parameter: String, val value: String) : _root_ide_package_.com.schuetz.parameterz.core.parameterdescriptors.DependsOn(_root_ide_package_.com.schuetz.parameterz.core.parameterdescriptors.DependsOn.Type.NOT)
    class JustDependsOn(val parameter: String, val value: String) : _root_ide_package_.com.schuetz.parameterz.core.parameterdescriptors.DependsOn(_root_ide_package_.com.schuetz.parameterz.core.parameterdescriptors.DependsOn.Type.JUST)

    companion object {
        fun not(parameter: String, value: String): _root_ide_package_.com.schuetz.parameterz.core.parameterdescriptors.DependsOn {
            return _root_ide_package_.com.schuetz.parameterz.core.parameterdescriptors.DependsOn.NotDependsOn(parameter, value)
        }

        fun just(parameter: String, value: String): _root_ide_package_.com.schuetz.parameterz.core.parameterdescriptors.DependsOn {
            return _root_ide_package_.com.schuetz.parameterz.core.parameterdescriptors.DependsOn.JustDependsOn(parameter, value)
        }

        fun and(vararg deps: _root_ide_package_.com.schuetz.parameterz.core.parameterdescriptors.DependsOn): _root_ide_package_.com.schuetz.parameterz.core.parameterdescriptors.DependsOn {
            return _root_ide_package_.com.schuetz.parameterz.core.parameterdescriptors.DependsOn.AndDependsOn(deps.toList())
        }

        fun or(vararg deps: _root_ide_package_.com.schuetz.parameterz.core.parameterdescriptors.DependsOn): _root_ide_package_.com.schuetz.parameterz.core.parameterdescriptors.DependsOn {
            return _root_ide_package_.com.schuetz.parameterz.core.parameterdescriptors.DependsOn.OrDependsOn(deps.toList())
        }
    }

    enum class Type {
        AND, OR, NOT, JUST
    }
}
