package com.example._1.customer.rest

import com.example._1.customer.service.CustomerService
import com.example._1.order.Order
import com.example._1.payment.Payment
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/customers")
class CustomerController(
    private val customerService: CustomerService
) {

    @PostMapping("/create")
    fun createCustomerWithOrderAndPayment(
        @RequestParam username: String,
        @RequestParam email: String,
        @RequestParam product: String,
        @RequestParam amount: Double
    ): ResponseEntity<String> {
        customerService.createCustomerWithOrderAndPayment(username, email, product, amount)
        return ResponseEntity.ok("Customer, Order, and Payment created successfully")
    }

    @GetMapping("/{customerId}/orders")
    fun getCustomerOrders(@PathVariable customerId: Long): ResponseEntity<List<Order>> {
        val orders = customerService.getCustomerOrders(customerId)
        return ResponseEntity.ok(orders)
    }

    @GetMapping("/order/{orderId}/payment")
    fun getCustomerPaymentForOrder(@PathVariable orderId: Long): ResponseEntity<Payment> {
        val payment = customerService.getCustomerPaymentForOrder(orderId)
        return ResponseEntity.ok(payment)
    }
}