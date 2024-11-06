package com.example._3.order

import com.example._3.customer.Customer
import com.example._3.customer.CustomerService
import com.example._3.order.repository.OrderRepository
import org.springframework.stereotype.Service


@Service
class OrderService(
    private val orderRepository: OrderRepository,
    private val customerService: CustomerService,
) {

    fun findById(id: Long) = orderRepository.findById(id)

    fun createOrderForCustomer(userId: Long, product: String, amount: Double) {
        val user: Customer = customerService.findById(userId)

        val newOrder = Order(1, user.id, product)
        orderRepository.save(newOrder)

//        val newPayment = Payment(1, newOrder.id, 0.0)
//        paymentService.createPayment(newPayment)

        println("Order and Payment for Customer created successfully.")
    }

    fun createOrder(order: Order) = orderRepository.save(order)

    fun getOrdersForCustomer(userId: Long): List<Order> {
        return orderRepository.findByCustomerId(userId)
    }

}