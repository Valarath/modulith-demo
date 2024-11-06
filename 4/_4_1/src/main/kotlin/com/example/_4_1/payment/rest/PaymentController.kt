package com.example._4_1.payment.rest

import com.example._4_1.model.Payment
import com.example._4_1.payment.service.PaymentService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/payments")
class PaymentController(
    private val paymentService: PaymentService
) {

    @PostMapping("/create")
    fun createPaymentForOrder(
        @RequestParam orderId: Long,
        @RequestParam amount: Double
    ): ResponseEntity<String> {
        paymentService.createPaymentForOrder(orderId, amount)
        return ResponseEntity.ok("Payment for Order created successfully")
    }

    @GetMapping("/order/{orderId}")
    fun getPaymentForOrder(@PathVariable orderId: Long): ResponseEntity<Payment> {
        val payment = paymentService.getPaymentForOrder(orderId)
        return ResponseEntity.ok(payment)
    }
}