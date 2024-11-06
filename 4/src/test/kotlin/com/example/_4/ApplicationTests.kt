package com.example._4

import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.modulith.core.ApplicationModule
import org.springframework.modulith.core.ApplicationModules

@SpringBootTest
class ApplicationTests {

    @Test
    fun verifyModules() {
        val modules: ApplicationModules = ApplicationModules.of(Application::class.java)
        modules.forEach { x: ApplicationModule? -> println(x) }
        modules.verify()
    }

}
