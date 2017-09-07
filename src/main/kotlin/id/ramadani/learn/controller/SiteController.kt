package id.ramadani.learn.controller

import id.ramadani.learn.ApplicationProperties
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(value = "/")
class SiteController constructor(val properties: ApplicationProperties) {

    @RequestMapping(method = arrayOf(RequestMethod.GET))
    fun index(): String = "app name ${properties.name} env ${properties.env}"
}