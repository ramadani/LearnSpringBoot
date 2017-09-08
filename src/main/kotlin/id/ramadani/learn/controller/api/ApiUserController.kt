package id.ramadani.learn.controller.api

import id.ramadani.learn.entity.User
import id.ramadani.learn.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(value = "/api/users")
class ApiUserController @Autowired constructor(val repository: UserRepository) {

    @RequestMapping(method = arrayOf(RequestMethod.GET))
    fun index(): Iterable<User> = repository.findAll()

    @RequestMapping(method = arrayOf(RequestMethod.POST))
    fun store(): String {
        val user = User(name = "Ramadani", email = "email.ramadani@gmail.com")
        repository.save(user)
        return "saved"
    }
}