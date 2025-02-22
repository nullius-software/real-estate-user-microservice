package com.nullius_real_estate.user_microservice.entity

import jakarta.persistence.Entity
import jakarta.persistence.Id
import java.util.UUID

@Entity
data class UserEntity (
    @Id
    val id: UUID = UUID.randomUUID(),
    val firstName: String?,
    val lastName: String?,
    val email: String,
    val externalId: String
)