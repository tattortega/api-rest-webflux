package co.com.sofka.apirestwebflux.repositorie;

import co.com.sofka.apirestwebflux.entity.Dato;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface Repositorio extends ReactiveMongoRepository<Dato, String> {
}
