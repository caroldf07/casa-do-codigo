package br.com.zup.crianovoautor.model

class AtualizaAutorRequest(val descricao: String) {

    fun toModelAtualizado(autor: Autor): Autor {
        return Autor(autor.nome, autor.email, descricao)
    }

}
