package com.example._1.customer.service

import com.example._1.customer.Customer
import com.example._1.order.Order
import com.example._1.order.service.OrderService
import com.example._1.payment.Payment
import com.example._1.payment.service.PaymentService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Lazy
import org.springframework.stereotype.Service

@Service
class CustomerService(
    private val customerProvider: CustomerProvider,
    private val customerUpdater: CustomerUpdater,
) {

    @Autowired
    @Lazy
    private lateinit var orderService: OrderService
    @Autowired
    @Lazy
    private lateinit var paymentService: PaymentService

    fun findById(id: Long) = customerProvider.findById(id)

    fun createCustomerWithOrderAndPayment(username: String, email: String, product: String, amount: Double) {
        val newCustomer = Customer(1, username, email)
        customerUpdater.update(newCustomer)

        val newOrder = Order(1, newCustomer.id, product)
        orderService.createOrder(newOrder)

        val newPayment = Payment(1, newOrder.id, amount)
        paymentService.createPayment(newPayment)

        println("Customer, Order, and Payment created successfully.")
    }

    fun getCustomerOrders(userId: Long): List<Order> {
        return orderService.getOrdersForCustomer(userId)
    }

    fun getCustomerPaymentForOrder(orderId: Long): Payment {
        return paymentService.findByOrderId(orderId)
    }
}