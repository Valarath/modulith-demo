package com.example._4_1.customer.service

import com.example._4_1.model.Customer
import com.example._4_1.model.FindOrderCustomer
import com.example._4_1.model.Order
import com.example._4_1.model.OrderCustomer
import com.example._4_1.model.FindPaymentCustomer
import com.example._4_1.model.Payment
import com.example._4_1.model.PaymentCustomer
import org.springframework.context.ApplicationEventPublisher
import org.springframework.modulith.events.ApplicationModuleListener
import org.springframework.stereotype.Service

@Service
class CustomerService(
    private val customerProvider: CustomerProvider,
    private val customerUpdater: CustomerUpdater,
    private val publisher: ApplicationEventPublisher
) {

    @ApplicationModuleListener
    fun findOrderCustomer(findOrderCustomer: FindOrderCustomer) = customerProvider.findById(findOrderCustomer.customerId)
        .also { publisher.publishEvent(OrderCustomer(it.id, findOrderCustomer.orderAmount, findOrderCustomer.product)) }

    @ApplicationModuleListener
    fun findPaymentCustomer(findPaymentCustomer: FindPaymentCustomer) = customerProvider.findById(findPaymentCustomer.order.customerId)
        .also { publisher.publishEvent(PaymentCustomer(it,findPaymentCustomer.order,findPaymentCustomer.amount)) }

    fun createCustomerWithOrderAndPayment(username: String, email: String, product: String, amount: Double) {
        val newCustomer = createUser(username, email)

        val newOrder = createOrder(newCustomer, product, amount)

        createPayment(newOrder, amount)

        println("Customer, Order, and Payment created successfully.")
    }

    private fun createPayment(newOrder: Order, amount: Double) {
        val newPayment = Payment(1, newOrder.id, amount)
        publisher.publishEvent(newPayment)
    }

    private fun createOrder(newCustomer: Customer, product: String, amount: Double): Order {
        val newOrder = Order(1, newCustomer.id, product)
        publisher.publishEvent(OrderCustomer(newCustomer.id, amount, product))
        return newOrder
    }

    private fun createUser(username: String, email: String): Customer {
        val newCustomer = Customer(1, username, email)
        customerUpdater.update(newCustomer)
        return newCustomer
    }

}