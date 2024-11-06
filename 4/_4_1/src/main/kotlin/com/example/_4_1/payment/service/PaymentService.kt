package com.example._4_1.payment.service

import com.example._4_1.model.*
import com.example._4_1.payment.repository.PaymentRepository
import org.springframework.context.ApplicationEventPublisher
import org.springframework.modulith.events.ApplicationModuleListener
import org.springframework.stereotype.Service


@Service
class PaymentService(
    private val paymentRepository: PaymentRepository,
    private val publisher: ApplicationEventPublisher
) {

    fun createPaymentForOrder(orderId: Long, amount: Double) =
        publisher.publishEvent(FindPaymentOrder(orderId, amount))

    @ApplicationModuleListener
    fun createPaymentForOrder(orderPayment: OrderPayment) =
        publisher.publishEvent(FindPaymentCustomer(orderPayment.order, orderPayment.amount))

    @ApplicationModuleListener
    fun createPaymentForOrder(paymentCustomer: PaymentCustomer) =
        Payment(1, paymentCustomer.order.id, paymentCustomer.amount)
            .also {
                paymentRepository.save(it)
                println("Payment for Order created successfully.")
            }


    @ApplicationModuleListener
    fun createPayment(payment: Payment) = paymentRepository.save(payment)

    fun getPaymentForOrder(orderId: Long): Payment {
        return paymentRepository.findByOrderId(orderId)
    }
}