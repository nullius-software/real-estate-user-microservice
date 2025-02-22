package com.nullius_real_estate.user_microservice.mapper

import com.nullius_real_estate.user_microservice.controller.dto.CreateUserDto
import com.nullius_real_estate.user_microservice.entity.UserEntity
import java.util.UUID

class UserMapper {
    fun fromCreateUserDtoToUserEntity(createUserDto: CreateUserDto): UserEntity {
        return UserEntity(
            id = UUID.randomUUID(),
            firstName = createUserDto.firstName,
            lastName = createUserDto.lastName,
            email = createUserDto.email,
            externalId = createUserDto.externalId
        )
    }
}