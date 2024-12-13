package test.testhexagonal.product.application.ports.input;

import reactor.core.publisher.Mono;

public interface DeleteProductUseCase {
    Mono<Void> deleteProduct(Long id);
}
