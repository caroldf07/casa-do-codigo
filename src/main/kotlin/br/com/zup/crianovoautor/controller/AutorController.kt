package br.com.zup.crianovoautor.controller

import br.com.zup.crianovoautor.NovoAutorRequest
import br.com.zup.crianovoautor.model.Autor
import br.com.zup.crianovoautor.model.DetalheDoAutorResponse
import br.com.zup.crianovoautor.repository.AutorRepository
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.*
import io.micronaut.validation.Validated
import javax.persistence.EntityManager
import javax.persistence.PersistenceContext
import javax.transaction.Transactional
import javax.validation.Valid


//Carga de 7
@Validated
@Controller("/autores")
class AutorController(@PersistenceContext val em: EntityManager, val autorRepository: AutorRepository) {

    @Post
    @Transactional
    //O Kotlin consegue inferir o @Body no corpo da requisição,
    // mas por boa prática é melhor deixar explícito
    fun cria(@Body @Valid request: NovoAutorRequest): HttpResponse<Any> {

        val autor: Autor = request.toModel()
        em.persist(autor)

        return HttpResponse.ok()
    }

    @Get
    @Transactional
    //QueryValue é o QueryParam
    fun busca(@QueryValue(defaultValue = "") email: String): HttpResponse<Any> {

        //1
        if (email.isBlank()) {
            val autores = autorRepository.findAll()
            val resposta = autores.map { autor -> DetalheDoAutorResponse(autor) }
            return HttpResponse.ok(resposta)
        }

        val autor = autorRepository.findByEmail(email)

        //1
        if (autor.isEmpty) {
            return HttpResponse.notFound()
        }

        return HttpResponse.ok(DetalheDoAutorResponse(autor.get()))
    }
}