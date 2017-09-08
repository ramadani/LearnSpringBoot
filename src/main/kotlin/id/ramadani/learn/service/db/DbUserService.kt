package id.ramadani.learn.service.db

import id.ramadani.learn.domain.User
import id.ramadani.learn.domain.UserRepository
import id.ramadani.learn.service.UserService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class DbUserService(private val repository: UserRepository) : UserService {

    override fun paginate(pageable: Pageable): Page<User> = repository.findAll(pageable)

    override fun create(name: String, email: String) {
        repository.save(User(name = name, email = email))
    }

    override fun show(id: Long): User = repository.findOne(id)

    override fun update(name: String, email: String, id: Long) {
        val user = repository.findOne(id).copy(name = name, email = email)
        repository.save(user)
    }

    override fun delete(id: Long) {
        repository.delete(id)
    }
}