package test.testhexagonal.product.application.ports.input;

import reactor.core.publisher.Mono;
import test.testhexagonal.product.domain.model.Product;


public interface CreateProductUseCase {
    Mono<Product> createProduct(Product product);
}
