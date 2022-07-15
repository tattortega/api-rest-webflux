package co.com.sofka.apirestwebflux;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface Repositorio extends ReactiveMongoRepository<Dato, String> {
}
