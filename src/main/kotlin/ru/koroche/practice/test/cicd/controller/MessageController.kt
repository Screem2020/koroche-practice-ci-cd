package ru.koroche.practice.test.cicd.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import ru.koroche.practice.test.cicd.dto.MessagesResponse
import ru.koroche.practice.test.cicd.service.MessageService

@RestController
@RequestMapping("/messages")
class MessageController(
    private val messageService: MessageService,
) {
    @GetMapping
    fun getAll(): MessagesResponse = messageService.getAll()
}
