package com.example._1.order.service

import com.example._1.customer.Customer
import com.example._1.customer.service.CustomerService
import com.example._1.order.Order
import com.example._1.order.repository.OrderRepository
import com.example._1.payment.Payment
import com.example._1.payment.service.PaymentService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Lazy
import org.springframework.stereotype.Service


@Service
class OrderService(
    private val orderRepository: OrderRepository,
    private val customerService: CustomerService,
) {
    @Autowired
    @Lazy
    private lateinit var paymentService: PaymentService
    fun findById(id: Long) = orderRepository.findById(id)

    fun createOrderForCustomer(userId: Long, product: String, amount: Double) {
        val user: Customer = customerService.findById(userId)

        val newOrder = Order(1, user.id, product)
        orderRepository.save(newOrder)

        val newPayment = Payment(1, newOrder.id, 0.0)
        paymentService.createPayment(newPayment)

        println("Order and Payment for Customer created successfully.")
    }

    fun createOrder(order: Order) = orderRepository.save(order)

    fun getOrdersForCustomer(userId: Long): List<Order> {
        return orderRepository.findByCustomerId(userId)
    }
}