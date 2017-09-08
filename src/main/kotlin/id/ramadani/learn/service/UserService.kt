package id.ramadani.learn.service

import id.ramadani.learn.domain.User
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable

interface UserService {

    fun paginate(pageable: Pageable): Page<User>
    fun create(name: String, email: String)
    fun show(id: Long): User
    fun update(name: String, email: String, id: Long)
    fun delete(id: Long)
}