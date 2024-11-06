package com.example._2.customer.service

import com.example._2.customer.repository.CustomerDbRepository
import com.example._2.customer.repository.CustomerElasticRepository
import org.springframework.stereotype.Service

@Service
class CustomerProvider(private val customerDbRepository: CustomerDbRepository, private val customerElasticRepository: CustomerElasticRepository) {

    fun findById(id: Long) = customerDbRepository.findById(id)
}