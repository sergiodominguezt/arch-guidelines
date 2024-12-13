package test.testhexagonal.product.infrastructure.adapters.output;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import test.testhexagonal.product.application.ports.output.ProductRepository;
import test.testhexagonal.product.domain.model.Product;
import test.testhexagonal.product.infrastructure.adapters.output.repository.ReactiveProductRepository;

@Repository
@RequiredArgsConstructor
public class H2ProductRepository implements ProductRepository {

    private final ReactiveProductRepository reactiveProductRepository;

    @Override
    public Mono<Product> save(Product product) {
        return reactiveProductRepository.save(product);
    }

    @Override
    public Mono<Product> findById(Long id) {
        return reactiveProductRepository.findById(id);
    }

    @Override
    public Flux<Product> findAll() {
        return reactiveProductRepository.findAll();
    }

    @Override
    public Mono<Void> deleteById(Long id) {
        return reactiveProductRepository.deleteById(id);
    }
}
