package br.com.orangetalents.casadocodigo.novoautor.controller;

import br.com.orangetalents.casadocodigo.novoautor.NovoAutorRequest;
import br.com.orangetalents.casadocodigo.novoautor.model.Autor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
public class AutorController {

    @PersistenceContext
    EntityManager em;

    @PostMapping("/autores")
    @Transactional
    public String criar(@RequestBody @Valid NovoAutorRequest novoAutor) {
        Autor autor = novoAutor.toModel();
        em.persist(autor);
        return autor.toString();
    }
}