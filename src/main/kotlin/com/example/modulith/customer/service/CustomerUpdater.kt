package com.example.modulith.customer.service

import com.example.modulith.customer.Customer
import com.example.modulith.customer.repository.CustomerDbRepository
import com.example.modulith.customer.repository.CustomerElasticRepository
import org.springframework.stereotype.Service

@Service
class CustomerUpdater(private val customerDbRepository: CustomerDbRepository, private val customerElasticRepository: CustomerElasticRepository) {

    fun update(customer: Customer) {
        customerDbRepository.save(customer)
        customerElasticRepository.save(customer)
    }
}