package br.com.zup.crianovoautor.model

import java.time.LocalDateTime
import java.util.*
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class Autor(
    val nome: String,
    val email: String,
    val descricao: String
) {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: UUID? = null
    var criadoEm: LocalDateTime = LocalDateTime.now()
}
