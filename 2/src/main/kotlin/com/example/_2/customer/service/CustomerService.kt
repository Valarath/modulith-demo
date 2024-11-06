package com.example._2.customer.service

import com.example._2.customer.Customer
import org.springframework.stereotype.Service

@Service
class CustomerService(
    private val customerProvider: CustomerProvider,
    private val customerUpdater: CustomerUpdater,
) {

    fun findById(id: Long) = customerProvider.findById(id)

    fun createCustomerWithOrderAndPayment(username: String, email: String, product: String, amount: Double) {
        val newCustomer = Customer(1, username, email)
        customerUpdater.update(newCustomer)

//        val newOrder = Order(1, newCustomer.id, product)
//        orderService.createOrder(newOrder)

//        val newPayment = Payment(1, newOrder.id, amount)
//        paymentService.createPayment(newPayment)

        println("Customer, Order, and Payment created successfully.")
    }


}