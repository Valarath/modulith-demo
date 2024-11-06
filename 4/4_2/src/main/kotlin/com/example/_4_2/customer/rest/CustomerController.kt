package com.example._4_2.customer.rest

import com.example._4_2.customer.service.CustomerService
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

}