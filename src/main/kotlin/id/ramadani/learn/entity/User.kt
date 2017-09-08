package id.ramadani.learn.entity

import org.springframework.data.jpa.repository.Temporal
import java.util.*
import javax.persistence.*

@Entity
data class User(
        @Id @GeneratedValue(strategy = GenerationType.AUTO) val id: Long = 0,
        val name: String? = null,
        val email: String? = null,
        @Column(insertable = true, updatable = false) @Temporal(TemporalType.DATE) val createdAt: Date = Date(),
        @Column(insertable = true, updatable = true) @Temporal(TemporalType.DATE) val updatedAt: Date = Date()
)