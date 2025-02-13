package com.nullius_real_estate.user_microservice

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean

@SpringBootApplication
class UserMicroserviceApplication

fun main(args: Array<String>) {
	runApplication<UserMicroserviceApplication>(*args)
}
