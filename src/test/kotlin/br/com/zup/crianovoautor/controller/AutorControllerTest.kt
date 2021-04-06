package br.com.zup.crianovoautor.controller

import br.com.zup.crianovoautor.NovoAutorRequest
import io.micronaut.http.HttpResponse
import io.micronaut.http.HttpStatus
import io.micronaut.http.client.HttpClient
import io.micronaut.http.client.annotation.Client
import io.micronaut.test.extensions.junit5.annotation.MicronautTest
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import javax.inject.Inject
import javax.validation.ConstraintViolationException

@MicronautTest
class AutorControllerTest {

    @Inject
    lateinit var autorController: AutorController

    @Inject
    @field:Client("/")
    lateinit var client: HttpClient

    @Test
    @DisplayName("Deve retornar erro de e-mail")
    fun testaCriaAutor1() {
        var request: NovoAutorRequest = NovoAutorRequest(nome = "Carol", email = "", descricao = "descricao")
        val exception = assertThrows<ConstraintViolationException> {
            autorController.cria(request = request)
        }

        assertEquals(
            "cria.request.email: must not be blank, cria.request.email: must be a well-formed email address",
            exception.message
        )

    }


    @Test
    @DisplayName("Deve retornar erro de nome em branco")
    fun testaCriaAutor2() {
        var request: NovoAutorRequest = NovoAutorRequest(nome = "", email = "email@email.com", descricao = "descricao")
        val exception = assertThrows<ConstraintViolationException> {
            autorController.cria(request = request)
        }
        assertEquals("cria.request.nome: must not be blank", exception.message)
    }

    @Test
    @DisplayName("Deve retornar erro de descrição em branco")
    fun testaCriaAutor4() {
        var request: NovoAutorRequest = NovoAutorRequest(nome = "teste", email = "email@email.com", descricao = "")
        val exception = assertThrows<ConstraintViolationException> {
            autorController.cria(request = request)
        }
        assertEquals("cria.request.descricao: must not be blank", exception.message)

    }

    @Test
    @DisplayName("Deve retornar erro de descrição maior que 400")
    fun testaCriaAutor5() {
        var request: NovoAutorRequest = NovoAutorRequest(
            nome = "teste",
            email = "email@email.com",
            descricao = """Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce at volutpat diam. Integer a hendrerit massa. Aliquam erat volutpat. Vestibulum mi diam, lobortis non tempor quis, feugiat quis risus. Sed maximus id dui at ornare. Mauris vitae laoreet nibh, sed laoreet dui. Morbi nisl diam, lobortis ut dignissim in, iaculis ut ex. Quisque orci mi, vestibulum ac diam a, venenatis blandit sapien. Suspendisse aliquet mauris sit amet leo porttitor, sit amet viverra est blandit. """
        )
        val exception = assertThrows<ConstraintViolationException> {
            autorController.cria(request = request)
        }
        assertEquals("cria.request.descricao: size must be between 0 and 400", exception.message)
    }

    @Test
    @DisplayName("Deve retornar 200")
    fun testaCriaAutor6() {
        var request: NovoAutorRequest = NovoAutorRequest(
            nome = "testeNovo",
            email = "email@email.com",
            descricao = "descricao"
        )

        var response: HttpResponse<Any> = autorController.cria(request)

        assertEquals(HttpStatus.OK, response.status())
    }
}