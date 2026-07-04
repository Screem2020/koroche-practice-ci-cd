package ru.koroche.practice.test.cicd.service

import org.springframework.stereotype.Service
import ru.koroche.practice.test.cicd.dto.MessagesResponse
import ru.koroche.practice.test.cicd.repository.MessageRepository
import java.util.UUID

@Service
class MessageService(
    private val messageRepository: MessageRepository,
) {
    // Генерируется один раз при создании сервиса и не меняется между запросами
    private val instanceId: String = UUID.randomUUID().toString()

    fun getAll(): MessagesResponse = MessagesResponse(
        instanceId = instanceId,
        messages = messageRepository.findAll(),
    )
}
