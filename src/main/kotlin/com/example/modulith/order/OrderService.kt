package com.example.modulith.order

import com.example.modulith.customer.Customer
import com.example.modulith.customer.service.CustomerProvider
import com.example.modulith.payment.Payment
import com.example.modulith.payment.PaymentRepository
import org.springframework.stereotype.Service


@Service
class OrderService(
    private val orderRepository: OrderRepository,
    private val customerProvider: CustomerProvider,
    private val paymentRepository: PaymentRepository
) {

    fun createOrderForCustomer(userId: Long, product: String, amount: Double) {
        val user: Customer = customerProvider.findById(userId)

        val newOrder = Order(1, user.id, product)
        orderRepository.save(newOrder)

        val newPayment = Payment(1, newOrder.id, amount)
        paymentRepository.save(newPayment)

        println("Order and Payment for Customer created successfully.")
    }

    fun getOrdersForCustomer(userId: Long): List<Order> {
        return orderRepository.findByCustomerId(userId)
    }
}