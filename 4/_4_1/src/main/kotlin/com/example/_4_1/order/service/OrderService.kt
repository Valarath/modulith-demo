package com.example._4_1.order.service

import com.example._4_1.model.FindOrderCustomer
import com.example._4_1.model.Order
import com.example._4_1.model.OrderCustomer
import com.example._4_1.order.repository.OrderRepository
import com.example._4_1.model.FindPaymentOrder
import com.example._4_1.model.OrderPayment
import com.example._4_1.model.Payment
import org.springframework.context.ApplicationEventPublisher
import org.springframework.modulith.events.ApplicationModuleListener
import org.springframework.stereotype.Service


@Service
class OrderService(
    private val orderRepository: OrderRepository,
    private val publisher: ApplicationEventPublisher
) {

    @ApplicationModuleListener
    fun findById(findPaymentOrder: FindPaymentOrder) = orderRepository.findById(findPaymentOrder.orderId)
        .also { publisher.publishEvent(OrderPayment(it,findPaymentOrder.amount)) }

    fun createOrderForCustomer(customerId: Long, product: String, amount: Double) {
        publisher.publishEvent(FindOrderCustomer(customerId,amount,product))
        println("Order and Payment for Customer created successfully.")
    }

    @ApplicationModuleListener
    fun createOrderForCustomer(order: OrderCustomer) = createOrder(Order(1,order.customerId, order.product))
        .also {publisher.publishEvent(Payment(1,it.id,0.0))}

    @ApplicationModuleListener
    fun createOrder(order: Order) = orderRepository.save(order)

    fun getOrdersForCustomer(userId: Long): List<Order> {
        return orderRepository.findByCustomerId(userId)
    }

}