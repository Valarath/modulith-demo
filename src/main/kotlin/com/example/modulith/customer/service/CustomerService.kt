package com.example.modulith.customer.service

import com.example.modulith.customer.Customer
import com.example.modulith.customer.repository.CustomerDbRepository
import com.example.modulith.order.Order
import com.example.modulith.order.OrderRepository
import com.example.modulith.payment.Payment
import com.example.modulith.payment.PaymentRepository
import org.springframework.stereotype.Service

@Service
class CustomerService(
    private val customerRepository: CustomerDbRepository,
    private val orderRepository: OrderRepository,
    private val paymentRepository: PaymentRepository,
    private val customerProvider: CustomerProvider
) {

    fun findCustomerById(id: Long) = customerProvider.findById(id)

    fun createCustomerWithOrderAndPayment(username: String, email: String, product: String, amount: Double) {
        val newCustomer: Customer = Customer(1, username, email)
        customerRepository.save(newCustomer)

        val newOrder: Order = Order(1, newCustomer.id, product)
        orderRepository.save(newOrder)

        val newPayment = Payment(1, newOrder.id, amount)
        paymentRepository.save(newPayment)

        println("Customer, Order, and Payment created successfully.")
    }

    fun getCustomerOrders(userId: Long): List<Order> {
        return orderRepository.findByCustomerId(userId)
    }

    fun getCustomerPaymentForOrder(orderId: Long): Payment {
        return paymentRepository.findByOrderId(orderId)
    }
}