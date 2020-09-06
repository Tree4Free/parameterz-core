# parameterz-core

![Alt text](./images/ParameterZ.svg)

A spring library to create parameter descriptions in a standardized way.

## Functionality

- Describing parameters of different types:
    - Text
    - Numbers
    - Booleans
    - Enums
- Defining dependencies between different parameters
- Defining validation rules
- Translation of parameter names, descriptions and possible values (for enums)

## Usage

To use this library you have to enable the `ParamameterBuilderService` with the `@EnableParameterBuilder` annotation.

Then you have to provide the different `ParameterBuilder<T>` implementations for each parameter implementation your application uses as Spring beans.

To use translations two additional beans have to be provided:

- A `TranslationLanguageSource` bean to determine the current language
- A `TranslationProvider` bean to provide translation values

Finally, you just have to autowire the `ParamameterBuilderService` bean and pass in your parameter implementations like so:

```kotlin
// val formSpecificParameters: ObjectWithParameters = ...

val parameters: Collection<Parameter> = paramameterBuilderService.constructParameters(formSpecificParameters)
```