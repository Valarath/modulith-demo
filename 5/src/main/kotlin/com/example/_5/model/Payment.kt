package com.example._5.model

data class Payment(val id: Long, val orderId: Long, val amount: Double)

data class FindPaymentOrder(val orderId: Long, val amount: Double)

data class OrderPayment(val order: Order, val amount: Double)

data class FindPaymentCustomer(val order: Order, val amount: Double)

data class PaymentCustomer(val customer: Customer, val order: Order, val amount: Double)
