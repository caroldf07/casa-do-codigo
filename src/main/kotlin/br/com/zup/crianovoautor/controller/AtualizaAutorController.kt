package br.com.zup.crianovoautor.controller

import br.com.zup.crianovoautor.model.AtualizaAutorRequest
import br.com.zup.crianovoautor.model.Autor
import br.com.zup.crianovoautor.repository.AutorRepository
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.*
import java.util.*

//Carga de 4
@Controller("/autores/{id}")
class AtualizaAutorController(val autorRepository: AutorRepository) {

    @Put
    fun atualiza(@PathVariable("id") id: UUID, @Body atualizarAutor: AtualizaAutorRequest): HttpResponse<Any> {
        val possivelAutor: Optional<Autor> = autorRepository.findById(id)

        //1
        if (possivelAutor.isEmpty) {
            return HttpResponse.notFound()
        }

        //Recebe o autor via pathVariable e a informação a ser atualizada via request/dto
        //1
        val autorAtulizar: Autor = atualizarAutor.toModelAtualizado(possivelAutor.get())

        autorRepository.update(autorAtulizar)

        return HttpResponse.ok()

    }

    @Delete
    fun delete(@PathVariable("id") id: UUID): HttpResponse<Any> {
        val possivelAutor: Optional<Autor> = autorRepository.findById(id)

        if (possivelAutor.isEmpty) {
            return HttpResponse.notFound()
        }

        autorRepository.deleteById(id)
        return HttpResponse.ok()
    }
}