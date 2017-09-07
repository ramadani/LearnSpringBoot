package id.ramadani.learn.controller

import id.ramadani.learn.domain.User
import id.ramadani.learn.handler.exceptions.NotFoundException
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
        val id = users[users.size - 1].id + 1
        users += User(id, "Ramadani", "Jakal 13.5")
    }

    @RequestMapping(value = "/{id}", method = arrayOf(RequestMethod.GET))
    fun show(@PathVariable id: Long): User {
        return users.find { it.id == id} ?: throw NotFoundException("User id $id not found")
    }

    @RequestMapping(value = "/{id}", method = arrayOf(RequestMethod.PUT))
    fun update(@PathVariable id: Long) {
        val oldUser = users.find { it.id == id } ?: throw NotFoundException("User id $id not found")
        val indexOf = users.indexOf(oldUser)
        val user = User(id, "Muhtarudin", "Jakal 14")

        users.removeAt(indexOf)
        users.add(indexOf, user)
    }

    @RequestMapping(value = "/{id}", method = arrayOf(RequestMethod.DELETE))
    fun destroy(@PathVariable id: Long) {
        users.remove(users.find { it.id == id })
    }
}