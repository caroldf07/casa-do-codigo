package br.com.zup.crianovoautor

import br.com.zup.crianovoautor.model.Autor
import io.micronaut.core.annotation.Introspected
import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Size

@Introspected
data class NovoAutorRequest(
    @field: NotBlank val nome: String,
    @field: NotBlank @field:Email val email: String,
    @field: NotBlank @field:Size(max = 400) val descricao: String

){
    fun toModel(): Autor {
        return Autor(nome, email, descricao)
    }
}