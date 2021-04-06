package br.com.zup.crianovoautor.repository

import br.com.zup.crianovoautor.model.Autor
import io.micronaut.data.annotation.Repository
import io.micronaut.data.jpa.repository.JpaRepository
import java.util.*

@Repository
interface AutorRepository : JpaRepository<Autor, UUID> {
    fun findByEmail(email: String): Optional<Autor>

}
