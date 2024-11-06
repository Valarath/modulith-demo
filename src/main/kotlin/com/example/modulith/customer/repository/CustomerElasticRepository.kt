package com.example.modulith.customer.repository

import com.example.modulith.customer.Customer
import org.springframework.stereotype.Service

@Service
class CustomerElasticRepository (private val customers: MutableMap<Long, Customer> = mutableMapOf()) {

    fun findById(id: Long): Customer {
        println("Fetching User with ID: $id")
        return customers.getValue(id)
    }

    fun save(customer: Customer) {
        println("Saving User: " + customer.username)
        customers[customer.id] = customer
    }
}