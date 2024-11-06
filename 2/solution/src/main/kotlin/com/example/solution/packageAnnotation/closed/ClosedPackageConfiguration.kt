package com.example.solution.packageAnnotation.closed

import org.springframework.context.annotation.Configuration
import org.springframework.modulith.ApplicationModule
import org.springframework.modulith.NamedInterface

@Configuration
@ApplicationModule(type = ApplicationModule.Type.CLOSED)
@NamedInterface("package-annotation")
class ClosedPackageConfiguration {
}