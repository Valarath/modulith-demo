package com.example.solution

import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.modulith.core.ApplicationModule
import org.springframework.modulith.core.ApplicationModules

@SpringBootTest
class SolutionApplicationTests {

    @Test
    fun verifyModules() {
        val modules: ApplicationModules = ApplicationModules.of(SolutionApplication::class.java)
        modules.forEach { x: ApplicationModule? -> println(x) }
        modules.verify()
    }

}
