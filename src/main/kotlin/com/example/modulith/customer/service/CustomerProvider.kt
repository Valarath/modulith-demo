package com.example.modulith.customer.service

import com.example.modulith.customer.repository.CustomerDbRepository
import com.example.modulith.customer.repository.CustomerElasticRepository
import org.springframework.stereotype.Service

@Service
class CustomerProvider(private val customerDbRepository: CustomerDbRepository, private val customerElasticRepository: CustomerElasticRepository) {

    fun findById(id: Long) = customerDbRepository.findById(id)
}