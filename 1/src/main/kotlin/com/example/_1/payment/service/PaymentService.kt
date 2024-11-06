package com.example._1.payment.service

import com.example._1.customer.service.CustomerService
import com.example._1.order.service.OrderService
import com.example._1.payment.Payment
import com.example._1.payment.repository.PaymentRepository
import org.springframework.stereotype.Service


@Service
class PaymentService(
    private val paymentRepository: PaymentRepository,
    private val customerService: CustomerService,
    private val orderService: OrderService
) {

    fun createPaymentForOrder(orderId: Long, amount: Double) {
        val order = orderService.findById(orderId)

        customerService.findById(order.customerId)

        val newPayment = Payment(1, orderId, amount)
        paymentRepository.save(newPayment)

        println("Payment for Order created successfully.")
    }

    fun findByOrderId(orderId: Long) = paymentRepository.findByOrderId(orderId)

    fun createPayment(payment: Payment) = paymentRepository.save(payment)

    fun getPaymentForOrder(orderId: Long): Payment {
        return paymentRepository.findByOrderId(orderId)
    }
}