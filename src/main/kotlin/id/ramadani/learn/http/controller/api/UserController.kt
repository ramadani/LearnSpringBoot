package id.ramadani.learn.http.controller.api

import id.ramadani.learn.domain.User
import id.ramadani.learn.service.UserService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(value = "/api/users")
class UserController(private val service: UserService) {

    @RequestMapping(method = arrayOf(RequestMethod.GET))
    fun index(pageable: Pageable): Page<User> = service.paginate(pageable)

    @RequestMapping(method = arrayOf(RequestMethod.POST))
    @ResponseStatus(HttpStatus.CREATED)
    fun store(@RequestParam name: String, @RequestParam email: String) {
        service.create(name, email)
    }

    @RequestMapping(value = "/{id}", method = arrayOf(RequestMethod.GET))
    fun show(@PathVariable id: Long): User {
        return service.show(id)
    }

    @RequestMapping(value = "/{id}", method = arrayOf(RequestMethod.PUT))
    fun update(@PathVariable id: Long, @RequestParam name: String, @RequestParam email: String) {
        service.update(name, email, id)
    }

    @RequestMapping(value = "/{id}", method = arrayOf(RequestMethod.DELETE))
    fun delete(@PathVariable id: Long) {
        service.delete(id)
    }
}