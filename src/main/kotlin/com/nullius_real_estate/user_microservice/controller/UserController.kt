package com.nullius_real_estate.user_microservice.controller

import com.nullius_real_estate.user_microservice.controller.dto.CreateUserDto
import com.nullius_real_estate.user_microservice.entity.UserEntity
import com.nullius_real_estate.user_microservice.mapper.UserMapper
import com.nullius_real_estate.user_microservice.repository.UserRepository
import com.nullius_real_estate.user_microservice.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/user")
class UserController {
    @Autowired
    lateinit var userService: UserService
    val userMapper = UserMapper()

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    fun getAll(): List<UserEntity> {
        return userService.getAll()
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody user: CreateUserDto): UserEntity {
        return userService.create(userMapper.fromCreateUserDtoToUserEntity(user))
    }
}