package co.com.sofka.apirestwebflux.router;

import co.com.sofka.apirestwebflux.dto.DatoDTO;
import co.com.sofka.apirestwebflux.entity.Dato;
import co.com.sofka.apirestwebflux.mapper.MapperUtils;
import co.com.sofka.apirestwebflux.repositorie.Repositorio;
import co.com.sofka.apirestwebflux.service.UseCaseCrear;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


@WebFluxTest
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {CrearDatoRouter.class, UseCaseCrear.class, MapperUtils.class})
class CrearDatoRouterTest {

    @MockBean
    private Repositorio repositorio;

    @Autowired
    private WebTestClient webTestClient;

    @Test
    public void testCreateUser() {

        Dato dato = new Dato();
        dato.setId("xxxxxxx");
        dato.setInformacion("Informacion 1");
        DatoDTO datoDTO = new DatoDTO(dato.getId(), dato.getInformacion());
        Mono<Dato> datoMono = Mono.just(dato);

        when(repositorio.save(any())).thenReturn(datoMono);


        webTestClient.post()
                .uri("/crear")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .body(Mono.just(datoDTO), DatoDTO.class)
                .exchange()
                .expectStatus().isOk()
                .expectBody(String.class)
                .value(userResponse -> {
                            Assertions.assertThat(userResponse).isEqualTo(dato.getId());
                        }
                );
    }

}