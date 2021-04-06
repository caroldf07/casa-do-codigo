package br.com.zup.crianovoautor.model

class DetalheDoAutorResponse(autor: Autor) {
    val nome: String = autor.nome
    val email: String = autor.email
    val descricao: String = autor.descricao
}
