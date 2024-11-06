package com.example._5.order

import com.example._5.customer.CustomerDependencyTestService
import com.example._5.model.Order
import com.example._5.model.OrderCustomer
import com.example._5.model.Payment
import com.example._5.order.repository.OrderRepository
import com.example._5.order.service.OrderService
import com.example._5.payment.PaymentDependencyTestService
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.modulith.test.ApplicationModuleTest
import org.springframework.modulith.test.Scenario

@ApplicationModuleTest
class OrderIntegrationStandaloneTest {

    @Autowired
    lateinit var orderService: OrderService

    @MockBean
    lateinit var paymentDependencyTestService: PaymentDependencyTestService

    @Test
    fun test() {
        orderService.forTest()
    }

}

@ApplicationModuleTest(ApplicationModuleTest.BootstrapMode.DIRECT_DEPENDENCIES)
class OrderIntegrationDirectDependenciesTest {

    @Autowired
    lateinit var orderService: OrderService

    @Autowired
    lateinit var paymentDependencyTestService: PaymentDependencyTestService

    //    @Autowired
    @MockBean
    lateinit var customerDependencyTestService: CustomerDependencyTestService

    @Test
    fun test() {
        orderService.forTest()
    }
}

@ApplicationModuleTest(ApplicationModuleTest.BootstrapMode.ALL_DEPENDENCIES)
class OrderIntegrationAllDependenciesTest {

    @Autowired
    lateinit var orderService: OrderService

    @Autowired
    lateinit var paymentDependencyTestService: PaymentDependencyTestService

    @Autowired
    lateinit var customerDependencyTestService: CustomerDependencyTestService

    @Test
    fun test() {
        orderService.forTest()
    }
}

@ApplicationModuleTest(ApplicationModuleTest.BootstrapMode.ALL_DEPENDENCIES)
class EventIntegrationTest {

    @Autowired
    lateinit var orderService: OrderService

    @Autowired
    lateinit var orderRepository: OrderRepository

    @Test
    fun testPublish(scenario: Scenario) {
        scenario.publish(OrderCustomer(1, 2.0, "1"))
            .andWaitForEventOfType(Payment::class.java)
            .toArrive()
    }

    @Test
    fun testStimulateArrive(scenario: Scenario) {
        scenario.stimulate { -> orderService.createOrderForCustomer(OrderCustomer(1, 2.0, "1")) }
            .andWaitForEventOfType(Payment::class.java)
            .toArrive()
    }

    @Test
    fun testStimulateWait(scenario: Scenario) {
        scenario.stimulate { -> orderService.createOrder(Order(1, 1, "1")) }
            .andWaitForStateChange { orderRepository.findById(1) != null }
    }
}