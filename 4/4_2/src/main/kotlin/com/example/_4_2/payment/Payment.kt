package com.example._4_2.payment

data class Payment(val id: Long, val orderId: Long, val amount: Double)

data class FindPaymentOrder(val orderId: Long, val amount: Double)

data class OrderPayment(val customerId: Long, val orderId: Long, val amount: Double)

data class FindPaymentCustomer(val customerId: Long, val orderId: Long, val amount: Double)

data class PaymentCustomer(val orderId: Long, val amount: Double)
