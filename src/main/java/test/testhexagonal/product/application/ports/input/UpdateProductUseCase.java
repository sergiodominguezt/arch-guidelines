package test.testhexagonal.product.application.ports.input;

import reactor.core.publisher.Mono;
import test.testhexagonal.product.domain.model.Product;

public interface UpdateProductUseCase {
    Mono<Product> updateProduct(Product product);
}
