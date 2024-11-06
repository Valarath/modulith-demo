package com.example.solution.packageAnnotation.other

import com.example.solution.packageAnnotation.open.OpenPackageAnnotationService
import org.springframework.stereotype.Service

@Service
class OpenOtherService(private val packageAnnotationService: OpenPackageAnnotationService) {
}