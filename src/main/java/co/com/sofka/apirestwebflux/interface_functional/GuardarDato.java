package co.com.sofka.apirestwebflux.interface_functional;

import co.com.sofka.apirestwebflux.dto.DatoDTO;
import reactor.core.publisher.Mono;

@FunctionalInterface
public interface GuardarDato {

    public Mono<String> apply(DatoDTO datoDTO);
}
