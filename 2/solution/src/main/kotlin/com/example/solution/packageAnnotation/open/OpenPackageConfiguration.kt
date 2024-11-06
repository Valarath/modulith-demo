package com.example.solution.packageAnnotation.open

import org.springframework.context.annotation.Configuration
import org.springframework.modulith.ApplicationModule
import org.springframework.modulith.NamedInterface

@Configuration
@ApplicationModule(type = ApplicationModule.Type.OPEN)
@NamedInterface("package-annotation")
class OpenPackageConfiguration {
}