package com.nullius_real_estate.user_microservice.controller

import com.nullius_real_estate.user_microservice.entity.UserEntity
import org.hamcrest.Matchers.hasSize
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.get
import org.springframework.test.web.servlet.post

@SpringBootTest
@AutoConfigureMockMvc
class UserControllerTest {

    @Autowired
    lateinit var mockMvc: MockMvc

    @Test
    fun `should retrieve all users`() {
        mockMvc.get("/api/user").andExpect {
            status { isOk() }
            content { contentType("application/json") }
            jsonPath("$") { hasSize<UserEntity>(3) }
        }
    }

    @Test
    fun `should create a user`() {
        val userJson = """
            {
                "firstName": "John",
                "lastName": "Doe",
                "email": "john.doe@example.com"
                "externalId": "mockExternalId"
            }
        """

        mockMvc.post("/api/user") {
            contentType = MediaType.APPLICATION_JSON
            content = userJson
        }.andExpect {
            status { isCreated() }
            content { contentType("application/json") }
            jsonPath("$.firstName") { value("John") }
            jsonPath("$.lastName") { value("Doe") }
            jsonPath("$.email") { value("john.doe@example.com") }
        }
    }
}