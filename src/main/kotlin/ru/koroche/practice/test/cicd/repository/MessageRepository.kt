package ru.koroche.practice.test.cicd.repository

import org.springframework.data.jpa.repository.JpaRepository
import ru.koroche.practice.test.cicd.entity.Message

interface MessageRepository : JpaRepository<Message, Long>