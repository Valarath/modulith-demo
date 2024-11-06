package com.example._5.order

import com.example._5.payment.PaymentAllDependencyTestService
import com.example._5.payment.PaymentDependencyTestService
import org.springframework.stereotype.Service

@Service
class OrderDependencyTestService(private val paymentDependencyTestService: PaymentDependencyTestService) {
}


@Service
class OrderAllDependencyTestService(private val paymentDependencyTestService: PaymentAllDependencyTestService) {
}