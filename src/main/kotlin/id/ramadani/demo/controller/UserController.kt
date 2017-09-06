package id.ramadani.demo.controller

import id.ramadani.demo.User
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(value = "/users")
class UserController {

    private val users = MutableList(10) {
        val id = it + 1
        User(id.toLong(), "name $id", "address $id")
    }

    @RequestMapping(method = arrayOf(RequestMethod.GET))
    fun index(): List<User> = users

    @RequestMapping(method = arrayOf(RequestMethod.POST))
    fun store() {
        users += User(100, "Ramadani", "Jakal 13.5")
    }

    @RequestMapping(value = "/{id}", method = arrayOf(RequestMethod.GET))
    fun show(@PathVariable id: Long): User? = users.find { it.id == id}
}