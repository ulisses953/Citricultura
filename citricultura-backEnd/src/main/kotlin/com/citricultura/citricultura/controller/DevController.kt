package com.citricultura.citricultura.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/dev")
class DevController {

    @GetMapping("public")
    fun publico(): String {
        return "publico"
    }

    @GetMapping("private")
    fun privado(): String {
        return "privado"
    }
}