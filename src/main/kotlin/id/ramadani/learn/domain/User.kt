package id.ramadani.learn.domain

import org.springframework.data.jpa.repository.Temporal
import java.util.*
import javax.persistence.*

@Entity
data class User(
        @Id @GeneratedValue(strategy = GenerationType.AUTO) val id: Long = 0,
        @Column(nullable = false) var name: String? = null,
        @Column(nullable = false) var email: String? = null,
        @Column(insertable = true, updatable = false, nullable = false) @Temporal(TemporalType.DATE) val createdAt: Date = Date(),
        @Column(insertable = true, updatable = true, nullable = false) @Temporal(TemporalType.DATE) val updatedAt: Date = Date()
)