package com.example._5.order.repository

import com.example._5.model.Order
import org.springframework.stereotype.Service

@Service
class OrderRepository(private val orders:MutableMap<Long, Order> = mutableMapOf()) {
    fun findById(id: Long): Order? {
        println("Fetching Order with ID: $id")
        return orders[id]
    }

    fun findByCustomerId(customerId: Long): List<Order> {
        println("Fetching Orders for User ID: $customerId")
        return orders.map { it.value }
            .filter { it.customerId == customerId }
    }

    fun save(order: Order): Order {
        println("Saving Order for User ID: " + order.customerId)
        orders[order.customerId] = order
        return order
    }

}