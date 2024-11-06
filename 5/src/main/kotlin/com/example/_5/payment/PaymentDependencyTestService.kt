package com.example._5.payment

import com.example._5.customer.CustomerDependencyTestService
import org.springframework.stereotype.Service

@Service
class PaymentDependencyTestService {
}

@Service
class PaymentAllDependencyTestService(private val customerDependencyTestService: CustomerDependencyTestService) {
}