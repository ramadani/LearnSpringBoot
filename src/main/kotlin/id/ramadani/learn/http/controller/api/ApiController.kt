package id.ramadani.learn.http.controller.api

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(value = "/api")
class ApiController {

    @RequestMapping(value = "/auth/login", method = arrayOf(RequestMethod.GET))
    fun login(): String = "Api Auth Login"

    @RequestMapping(value = "/dashboard", method = arrayOf(RequestMethod.GET))
    fun dashboard(): String = "Api Dashboard"
}