package com.example._4_2.order

data class Order(val id: Long, val customerId: Long, val product: String)

data class FindOrderCustomer(val customerId: Long, val orderAmount: Double, val product: String)

data class OrderCustomer(val customerId: Long, val orderAmount: Double, val product: String)
