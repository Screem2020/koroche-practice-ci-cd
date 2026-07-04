package ru.koroche.practice.test.cicd.dto

import ru.koroche.practice.test.cicd.entity.Message

data class MessagesResponse(
    val instanceId: String,
    val messages: List<Message>,
)
