package com.nullius_real_estate.user_microservice.controller.dto

data class CreateUserDto(
    val firstName: String?,
    val lastName: String?,
    val email: String,
    val externalId: String
)