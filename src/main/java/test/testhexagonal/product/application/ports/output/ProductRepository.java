package test.testhexagonal.product.application.ports.output;


import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import test.testhexagonal.product.domain.model.Product;

public interface ProductRepository {

    Mono<Product> save(Product product); // Guarda un producto y devuelve un Mono que emitirá el producto guardado
    Mono<Product> findById(Long id); // Devuelve un Mono que emitirá el producto si se encuentra por su id
    Flux<Product> findAll(); // Devuelve un Flux que emitirá todos los productos
    Mono<Void> deleteById(Long id); // Elimina un producto por su id y devuelve un Mono vacío cuando la operación completa
}