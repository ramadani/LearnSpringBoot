package id.ramadani.learn.repository

import id.ramadani.learn.entity.User
import org.springframework.data.repository.CrudRepository

interface UserRepository : CrudRepository<User, Long>