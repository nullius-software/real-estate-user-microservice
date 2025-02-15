package com.nullius_real_estate.user_microservice.service

import com.nullius_real_estate.user_microservice.entity.UserEntity
import com.nullius_real_estate.user_microservice.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class UserService(val userRepository: UserRepository) {
    fun getAll(): List<UserEntity> {
        return userRepository.findAll()
    }

    fun create(user: UserEntity): UserEntity {
        return userRepository.save(user)
    }
}