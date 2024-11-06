package com.example.modulith.payment

import com.example.modulith.customer.Customer
import com.example.modulith.customer.repository.CustomerDbRepository
import com.example.modulith.order.OrderRepository
import org.springframework.stereotype.Service


@Service
class PaymentService(
    private val paymentRepository: PaymentRepository,
    private val orderRepository: OrderRepository,
    private val userRepository: CustomerDbRepository
) {

    fun createPaymentForOrder(orderId: Long, amount: Double) {
        val order = orderRepository.findById(orderId)

        val user: Customer = userRepository.findById(order.id)

        val newPayment = Payment(1, orderId, amount)
        paymentRepository.save(newPayment)

        println("Payment for Order created successfully.")
    }

    fun getPaymentForOrder(orderId: Long): Payment {
        return paymentRepository.findByOrderId(orderId)
    }
}