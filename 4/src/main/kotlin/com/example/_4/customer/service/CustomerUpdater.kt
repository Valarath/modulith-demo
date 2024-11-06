package com.example._4.customer.service

import com.example._4.customer.Customer
import com.example._4.customer.repository.CustomerDbRepository
import com.example._4.customer.repository.CustomerElasticRepository
import org.springframework.stereotype.Service

@Service
class CustomerUpdater(private val customerDbRepository: CustomerDbRepository, private val customerElasticRepository: CustomerElasticRepository) {

    fun update(customer: Customer) {
        customerDbRepository.save(customer)
        customerElasticRepository.save(customer)
    }
}