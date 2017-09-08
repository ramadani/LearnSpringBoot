package id.ramadani.learn.controller.api

import id.ramadani.learn.entity.User
import id.ramadani.learn.repository.UserRepository
import id.ramadani.learn.handler.exceptions.NotFoundException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(value = "/api/users")
class UserController @Autowired constructor(val repository: UserRepository) {

    @RequestMapping(method = arrayOf(RequestMethod.GET))
    fun index(pageable: Pageable): Page<User> = repository.findAll(pageable)

    @RequestMapping(method = arrayOf(RequestMethod.POST))
    @ResponseStatus(HttpStatus.CREATED)
    fun store(@RequestParam name: String, @RequestParam email: String) {
        repository.save(User(name = name, email = email))
    }

    @RequestMapping(value = "/{id}", method = arrayOf(RequestMethod.GET))
    fun show(@PathVariable id: Long): User {
        return repository.findOne(id) ?: throw NotFoundException("User with id $id not found")
    }

    @RequestMapping(value = "/{id}", method = arrayOf(RequestMethod.PUT))
    fun update(@PathVariable id: Long, @RequestParam name: String, @RequestParam email: String) {
        val user = repository.findOne(id).copy(name = name, email = email)
        repository.save(user)
    }

    @RequestMapping(value = "/{id}", method = arrayOf(RequestMethod.DELETE))
    fun delete(@PathVariable id: Long) {
        repository.delete(id)
    }
}