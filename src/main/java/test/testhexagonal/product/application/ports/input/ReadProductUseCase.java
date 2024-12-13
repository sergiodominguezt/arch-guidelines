package test.testhexagonal.product.application.ports.input;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import test.testhexagonal.product.domain.model.Product;

public interface ReadProductUseCase {
    Mono<Product> getProduct(Long id);

    Flux<Product> getAllProducts();
}
