package com.example.modulith

import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.modulith.core.ApplicationModule
import org.springframework.modulith.core.ApplicationModules
import org.springframework.modulith.docs.Documenter


@SpringBootTest
class ModulithApplicationTests {

    @Test
    fun verifyModules() {
        val modules: ApplicationModules = ApplicationModules.of(ModulithApplication::class.java)
        createDocumentation(modules)
        modules.forEach { x: ApplicationModule? -> println(x) }
        modules.verify()
    }

    private fun createDocumentation(modules: ApplicationModules) {
        Documenter(modules)
            .writeDocumentation()
            .writeIndividualModulesAsPlantUml();
    }
}
