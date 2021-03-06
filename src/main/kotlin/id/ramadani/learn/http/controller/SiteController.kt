package id.ramadani.learn.http.controller

import id.ramadani.learn.ApplicationProperties
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(value = "/")
class SiteController constructor(val properties: ApplicationProperties) {

    @RequestMapping(method = arrayOf(RequestMethod.GET))
    fun index(): String = "Welcome to ${properties.name}'s api"
}