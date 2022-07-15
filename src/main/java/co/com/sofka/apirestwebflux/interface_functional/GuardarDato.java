package co.com.sofka.apirestwebflux;

import reactor.core.publisher.Mono;

@FunctionalInterface
public interface GuardarDato {

    public Mono<String> apply(DatoDTO datoDTO);
}
