package br.com.zup.crianovoautor.controller

import br.com.zup.crianovoautor.NovoAutorRequest
import br.com.zup.crianovoautor.model.Autor
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Post
import io.micronaut.validation.Validated
import javax.persistence.EntityManager
import javax.persistence.PersistenceContext
import javax.transaction.Transactional
import javax.validation.Valid


//Carga de 3
@Validated
@Controller("/autores")
class AutorController(@PersistenceContext val em: EntityManager) {

    @Post
    @Transactional
    //O Kotlin consegue inferir o @Body no corpo da requisição,
    // mas por boa prática é melhor deixar explícito
    fun cria(@Body @Valid request: NovoAutorRequest) {
        println("Request: ${request}")

        val autor: Autor = request.toModel()
        em.persist(autor)

        println("Model: ${autor.nome}")
    }
}