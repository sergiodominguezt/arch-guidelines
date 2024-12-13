package test.testhexagonal.product.infrastructure.adapters.output.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import test.testhexagonal.product.domain.model.Product;

@Repository
public interface ReactiveProductRepository extends ReactiveCrudRepository<Product, Long> {
}
