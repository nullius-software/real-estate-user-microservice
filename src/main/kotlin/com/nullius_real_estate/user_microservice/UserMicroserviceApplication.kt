package com.nullius_real_estate.user_microservice

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class UserMicroserviceApplication

fun main(args: Array<String>) {
	runApplication<UserMicroserviceApplication>(*args)
}
