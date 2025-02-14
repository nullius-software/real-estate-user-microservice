package com.nullius_real_estate.user_microservice.repository.mock

import com.nullius_real_estate.user_microservice.entity.UserEntity
import com.nullius_real_estate.user_microservice.repository.UserRepository
import org.springframework.data.domain.*
import org.springframework.data.repository.query.FluentQuery
import org.springframework.stereotype.Repository
import java.util.*
import java.util.function.Function

@Repository
class UserRepository: UserRepository {

    private val userList = mutableListOf<UserEntity>()

    override fun <S : UserEntity?> save(entity: S & Any): S & Any {
        userList.add(entity as UserEntity)
        return entity
    }

    override fun <S : UserEntity?> saveAll(entities: MutableIterable<S>): MutableList<S> {
        TODO("Not yet implemented")
    }

    override fun findById(id: UUID): Optional<UserEntity> {
        TODO("Not yet implemented")
    }

    override fun existsById(id: UUID): Boolean {
        TODO("Not yet implemented")
    }

    override fun findAll(): MutableList<UserEntity> {
        return userList
    }

    override fun findAll(sort: Sort): MutableList<UserEntity> {
        val comparator = sort.map { order ->
            val property = order.property
            val direction = if (order.isAscending) 1 else -1
            Comparator<UserEntity> { a, b ->
                when (property) {
                    "firstName" -> direction * a.firstName.compareTo(b.firstName)
                    "lastName" -> direction * a.lastName.compareTo(b.lastName)
                    "email" -> direction * a.email.compareTo(b.email)
                    else -> 0
                }
            }
        }.reduce { acc, comparator -> acc.thenComparing(comparator) }

        return userList.sortedWith(comparator).toMutableList()
    }

    override fun findAll(pageable: Pageable): Page<UserEntity> {
        val start = pageable.offset.toInt()
        val end = (start + pageable.pageSize).coerceAtMost(userList.size)
        val pageContent = userList.subList(start, end)
        return PageImpl(pageContent, pageable, userList.size.toLong())
    }


    override fun <S : UserEntity> findAll(example: Example<S>): MutableList<S> {
        val results = userList.filter {
            it == example.probe
        }.toMutableList() as MutableList<S>
        return results
    }

    override fun <S : UserEntity?> findAll(example: Example<S>, sort: Sort): MutableList<S> {
        val comparator = sort.map { order ->
            val property = order.property
            val direction = if (order.isAscending) 1 else -1
            Comparator<UserEntity> { a, b ->
                when (property) {
                    "firstName" -> direction * a.firstName.compareTo(b.firstName)
                    "lastName" -> direction * a.lastName.compareTo(b.lastName)
                    "email" -> direction * a.email.compareTo(b.email)
                    else -> 0
                }
            }
        }.reduce { acc, comparator -> acc.thenComparing(comparator) }

        val results = userList.filter {
            it == example.probe
        }.sortedWith(comparator).toMutableList() as MutableList<S>
        return results
    }

    override fun <S : UserEntity?> findAll(example: Example<S>, pageable: Pageable): Page<S> {
        val filteredList = userList.filter { it == example.probe } as MutableList<S>
        val start = pageable.offset.toInt()
        val end = (start + pageable.pageSize).coerceAtMost(userList.size)
        val pageContent = filteredList.subList(start, end)
        return PageImpl(pageContent, pageable, filteredList.size.toLong())
    }

    override fun findAllById(ids: MutableIterable<UUID>): MutableList<UserEntity> {
        TODO("Not yet implemented")
    }

    override fun count(): Long {
        TODO("Not yet implemented")
    }

    override fun <S : UserEntity?> count(example: Example<S>): Long {
        TODO("Not yet implemented")
    }

    override fun deleteById(id: UUID) {
        TODO("Not yet implemented")
    }

    override fun delete(entity: UserEntity) {
        TODO("Not yet implemented")
    }

    override fun deleteAllById(ids: MutableIterable<UUID>) {
        TODO("Not yet implemented")
    }

    override fun deleteAll(entities: MutableIterable<UserEntity>) {
        TODO("Not yet implemented")
    }

    override fun deleteAll() {
        TODO("Not yet implemented")
    }

    override fun <S : UserEntity?> findOne(example: Example<S>): Optional<S> {
        TODO("Not yet implemented")
    }

    override fun <S : UserEntity?> exists(example: Example<S>): Boolean {
        TODO("Not yet implemented")
    }

    override fun <S : UserEntity?, R : Any?> findBy(
        example: Example<S>,
        queryFunction: Function<FluentQuery.FetchableFluentQuery<S>, R>
    ): R & Any {
        TODO("Not yet implemented")
    }

    override fun flush() {
        TODO("Not yet implemented")
    }

    override fun <S : UserEntity?> saveAndFlush(entity: S & Any): S & Any {
        TODO("Not yet implemented")
    }

    override fun <S : UserEntity?> saveAllAndFlush(entities: MutableIterable<S>): MutableList<S> {
        TODO("Not yet implemented")
    }

    override fun deleteAllInBatch(entities: MutableIterable<UserEntity>) {
        TODO("Not yet implemented")
    }

    override fun deleteAllInBatch() {
        TODO("Not yet implemented")
    }

    override fun deleteAllByIdInBatch(ids: MutableIterable<UUID>) {
        TODO("Not yet implemented")
    }

    override fun getOne(id: UUID): UserEntity {
        TODO("Not yet implemented")
    }

    override fun getById(id: UUID): UserEntity {
        TODO("Not yet implemented")
    }

    override fun getReferenceById(id: UUID): UserEntity {
        TODO("Not yet implemented")
    }
}