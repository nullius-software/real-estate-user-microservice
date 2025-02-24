package com.nullius_real_estate.user_microservice.service

import com.nullius_real_estate.user_microservice.entity.UserEntity
import com.nullius_real_estate.user_microservice.repository.UserRepository
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import java.util.UUID
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class UserServiceTest {
    @Mock private lateinit var dataSource: UserRepository
    private lateinit var userService: UserService

    @BeforeEach
    fun setUp() {
        MockitoAnnotations.openMocks(this)
        userService = UserService(dataSource)
    }

    @Test
    fun getAll() {
        val user1 = UserEntity(UUID.randomUUID(), "John", "Doe", "john.doe@example.com", "mockExternalId")
        val user2 = UserEntity(UUID.randomUUID(), "Jane", "Doe", "jane.doe@example.com", "mockExternalId")

        Mockito.`when`(dataSource.findAll()).thenReturn(listOf(user1, user2))

        val result = userService.getAll()
        assertEquals(2, result.size)
        assertTrue(result.contains(user1))
        assertTrue(result.contains(user2))
    }

    @Test
    fun create() {
        val user = UserEntity(UUID.randomUUID(), "John", "Doe", "john.doe@example.com", "mockExternalId")

        Mockito.`when`(dataSource.save(user)).thenReturn(user)

        val result = userService.create(user)
        assertEquals(user, result)
    }
}

