package com.example.solution.packageAnnotation.other

import com.example.solution.packageAnnotation.closed.ClosedPackageAnnotationService
import org.springframework.stereotype.Service

@Service
class ClosedOtherService(private val packageAnnotationService: ClosedPackageAnnotationService) {
}