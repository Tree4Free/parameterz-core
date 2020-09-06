package com.schuetz.parameterz.core.parameterdescriptors.foundation.exceptions


class NoSuitableBuilderException(val clazz: Class<*>) : RuntimeException("No suitable parameter builder found for type $clazz")
