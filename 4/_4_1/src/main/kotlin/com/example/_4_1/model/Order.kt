package com.example._4_1.model

data class Order(val id: Long, val customerId: Long, val product: String)

data class FindOrderCustomer(val customerId: Long, val orderAmount: Double, val product: String)

data class OrderCustomer(val customerId: Long, val orderAmount: Double, val product: String)
