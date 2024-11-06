package com.example._4_2.order.rest

import com.example._4_2.order.Order
import com.example._4_2.order.service.OrderService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/orders")
class OrderController(
    private val orderService: OrderService
) {

    @PostMapping("/create")
    fun createOrderForCustomer(
        @RequestParam customerId: Long,
        @RequestParam product: String,
        @RequestParam amount: Double
    ): ResponseEntity<String> {
        orderService.createOrderForCustomer(customerId, product, amount)
        return ResponseEntity.ok("Order and Payment for Customer created successfully")
    }

    @GetMapping("/customer/{customerId}")
    fun getOrdersForCustomer(@PathVariable customerId: Long): ResponseEntity<List<Order>> {
        val orders = orderService.getOrdersForCustomer(customerId)
        return ResponseEntity.ok(orders)
    }
}