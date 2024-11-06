package com.example._4.payment

import com.example._4.customer.Customer
import com.example._4.order.Order

data class Payment(val id: Long, val orderId: Long, val amount: Double)

data class FindPaymentOrder(val orderId: Long, val amount: Double)

data class OrderPayment(val order: Order, val amount: Double)

data class FindPaymentCustomer(val order: Order, val amount: Double)

data class PaymentCustomer(val customer: Customer, val order: Order, val amount: Double)
