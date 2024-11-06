package com.example._3.order.repository

import com.example._3.order.Order
import org.springframework.stereotype.Service

@Service
class OrderRepository(private val orders:MutableMap<Long, Order> = mutableMapOf()) {
    fun findById(id: Long): Order {
        println("Fetching Order with ID: $id")
        return orders.getValue(id)
    }

    fun findByCustomerId(customerId: Long): List<Order> {
        println("Fetching Orders for User ID: $customerId")
        return orders.map { it.value }
            .filter { it.customerId == customerId }
    }

    fun save(order: Order) {
        println("Saving Order for User ID: " + order.customerId)
        orders[order.customerId] = order
    }

}