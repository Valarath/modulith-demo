package com.example._4_2.payment.service

import com.example._4_2.payment.repository.PaymentRepository
import com.example._4_2.payment.*
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
        publisher.publishEvent(FindPaymentCustomer(orderPayment.customerId, orderPayment.orderId, orderPayment.amount))

    @ApplicationModuleListener
    fun createPaymentForOrder(paymentCustomer: PaymentCustomer) =
        Payment(1, paymentCustomer.orderId, paymentCustomer.amount)
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