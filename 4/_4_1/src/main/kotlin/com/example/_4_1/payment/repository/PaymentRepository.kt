package com.example._4_1.payment.repository

import com.example._4_1.model.Payment
import org.springframework.stereotype.Service

@Service
class PaymentRepository(private val payments:MutableMap<Long, Payment> = mutableMapOf()) {

    fun findByOrderId(orderId: Long): Payment {
        println("Fetching Payment for Order ID: $orderId")
        return payments
            .map { it.value }
            .first { it.orderId == orderId }
    }

    fun save(payment: Payment) {
        println("Saving Payment for Order ID: " + payment.orderId)
        payments[payment.orderId] = payment
    }
}