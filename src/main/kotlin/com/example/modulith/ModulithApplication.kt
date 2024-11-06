package com.example.modulith

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
//import org.springframework.modulith.core.ApplicationModules

@SpringBootApplication
class ModulithApplication

fun main(args: Array<String>) {
//    ApplicationModules.of(ModulithApplication::class.java).verify()
    runApplication<ModulithApplication>(*args)
}
