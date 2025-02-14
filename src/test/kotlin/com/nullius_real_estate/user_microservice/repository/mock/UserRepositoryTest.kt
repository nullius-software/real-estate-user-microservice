package com.nullius_real_estate.user_microservice.repository.mock

import com.nullius_real_estate.user_microservice.entity.UserEntity
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.springframework.data.domain.Example
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort
import java.util.*

class UserRepositoryTest {
    private val mockUserRepository = UserRepository()

    @Test
    fun `should create a User`() {
        val user = UserEntity(UUID.randomUUID(), "first name", "last name", "email@email.com")
        val savedUser = mockUserRepository.save(user)
        assertNotNull(savedUser)
        assertEquals(user, savedUser)
    }

    @Test
    fun `should provide a collection of users`() {
        val userList = mockUserRepository.findAll()
        assertNotNull(userList)
        assertTrue(userList.isEmpty())
    }

    @Test
    fun `should find all users ordered by first name asc`() {
        val user1 = UserEntity(UUID.randomUUID(), "ana", "perez", "ana.perez@gmail.com")
        val user2 = UserEntity(UUID.randomUUID(), "juan", "lopez", "juan.lopez@gmail.com")
        val user3 = UserEntity(UUID.randomUUID(), "maria", "garcia", "maria.garcia@gmail.com")

        // Assume mockUserRepository is already populated with user1, user2, user3
        mockUserRepository.save(user1)
        mockUserRepository.save(user2)
        mockUserRepository.save(user3)

        val sort = Sort.by(Sort.Order.asc("firstName"))
        val matchingUsers = mockUserRepository.findAll(sort)

        assertNotNull(matchingUsers)
        assertEquals(3, matchingUsers.size)
        assertEquals("ana", matchingUsers[0].firstName)
        assertEquals("juan", matchingUsers[1].firstName)
        assertEquals("maria", matchingUsers[2].firstName)
    }

    @Test
    fun `should find all users ordered by last name asc`() {
        val user1 = UserEntity(UUID.randomUUID(), "ana", "perez", "ana.perez@gmail.com")
        val user2 = UserEntity(UUID.randomUUID(), "juan", "lopez", "juan.lopez@gmail.com")
        val user3 = UserEntity(UUID.randomUUID(), "maria", "garcia", "maria.garcia@gmail.com")

        // Assume mockUserRepository is already populated with user1, user2, user3
        mockUserRepository.save(user1)
        mockUserRepository.save(user2)
        mockUserRepository.save(user3)

        val sort = Sort.by(Sort.Order.asc("lastName"))
        val matchingUsers = mockUserRepository.findAll(sort)

        assertNotNull(matchingUsers)
        assertEquals(3, matchingUsers.size)
        assertEquals("garcia", matchingUsers[0].lastName)
        assertEquals("lopez", matchingUsers[1].lastName)
        assertEquals("perez", matchingUsers[2].lastName)
    }

    @Test
    fun `should find all users ordered by email asc`() {
        val user1 = UserEntity(UUID.randomUUID(), "ana", "perez", "ana.perez@gmail.com")
        val user2 = UserEntity(UUID.randomUUID(), "juan", "lopez", "juan.lopez@gmail.com")
        val user3 = UserEntity(UUID.randomUUID(), "maria", "garcia", "maria.garcia@gmail.com")

        // Assume mockUserRepository is already populated with user1, user2, user3
        mockUserRepository.save(user1)
        mockUserRepository.save(user2)
        mockUserRepository.save(user3)

        val sort = Sort.by(Sort.Order.asc("email"))
        val matchingUsers = mockUserRepository.findAll(sort)

        assertNotNull(matchingUsers)
        assertEquals(3, matchingUsers.size)
        assertEquals("ana.perez@gmail.com", matchingUsers[0].email)
        assertEquals("juan.lopez@gmail.com", matchingUsers[1].email)
        assertEquals("maria.garcia@gmail.com", matchingUsers[2].email)
    }

    @Test
    fun `should find all users with pagination`() {
        val user1 = UserEntity(UUID.randomUUID(), "John", "Doe", "john.doe@example.com")
        val user2 = UserEntity(UUID.randomUUID(), "Jane", "Doe", "jane.doe@example.com")
        val user3 = UserEntity(UUID.randomUUID(), "Alice", "Smith", "alice.smith@example.com")

        // Assume mockUserRepository is already populated with user1, user2, user3
        mockUserRepository.save(user1)
        mockUserRepository.save(user2)
        mockUserRepository.save(user3)

        val pageable = PageRequest.of(0, 2)
        val page = mockUserRepository.findAll(pageable)

        assertNotNull(page)
        assertEquals(2, page.content.size)
        assertEquals(3, page.totalElements)
        assertTrue(page.content.containsAll(listOf(user1, user2)))
    }

    @Test
    fun `should find all users that match a given example`() {
        val user1 = UserEntity(UUID.randomUUID(), "John", "Doe", "john.doe@example.com")
        val user2 = UserEntity(UUID.randomUUID(), "Jane", "Doe", "jane.doe@example.com")
        val user3 = UserEntity(UUID.randomUUID(), "Alice", "Smith", "alice.smith@example.com")

        // Assume mockUserRepository is already populated with user1, user2, user3
        mockUserRepository.save(user1)
        mockUserRepository.save(user2)
        mockUserRepository.save(user3)

        val example = Example.of(user1)
        val matchingUsers = mockUserRepository.findAll(example)

        assertNotNull(matchingUsers)
        assertEquals(1, matchingUsers.size)
        assertEquals("John", matchingUsers[0].firstName)
        assertEquals("Doe", matchingUsers[0].lastName)
    }

    @Test
    fun `should find all users that match a given example and are sorted by first name`() {
        val user1 = UserEntity(UUID.randomUUID(), "John", "Doe", "john.doe@example.com")
        val user2 = UserEntity(UUID.randomUUID(), "Jane", "Doe", "jane.doe@example.com")
        val user3 = UserEntity(UUID.randomUUID(), "Alice", "Smith", "alice.smith@example.com")

        // Assume mockUserRepository is already populated with user1, user2, user3
        mockUserRepository.save(user1)
        mockUserRepository.save(user2)
        mockUserRepository.save(user3)

        val example = Example.of(user1)
        val sort = Sort.by(Sort.Order.asc("firstName"))
        val matchingUsers = mockUserRepository.findAll(example, sort)

        assertNotNull(matchingUsers)
        assertEquals(1, matchingUsers.size)
        assertEquals("John", matchingUsers[0].firstName)
        assertEquals("Doe", matchingUsers[0].lastName)
    }

    @Test
    fun `should find all users that match a given example with pagination`() {
        val user1 = UserEntity(UUID.randomUUID(), "John", "Doe", "john.doe@example.com")
        val user2 = UserEntity(UUID.randomUUID(), "Jane", "Doe", "jane.doe@example.com")
        val user3 = UserEntity(UUID.randomUUID(), "Alice", "Smith", "alice.smith@example.com")

        // Assume mockUserRepository is already populated with user1, user2, user3
        mockUserRepository.save(user1)
        mockUserRepository.save(user2)
        mockUserRepository.save(user3)

        val example = Example.of(user1)
        val pageable = PageRequest.of(0, 1)
        val page = mockUserRepository.findAll(example, pageable)

        assertNotNull(page)
        assertEquals(1, page.content.size)
        assertEquals(1, page.totalElements)
        assertTrue(page.content.contains(user1))
    }
}