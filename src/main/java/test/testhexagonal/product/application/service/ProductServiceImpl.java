package test.testhexagonal.product.application.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import test.testhexagonal.product.application.ports.input.CreateProductUseCase;
import test.testhexagonal.product.application.ports.input.DeleteProductUseCase;
import test.testhexagonal.product.application.ports.input.ReadProductUseCase;
import test.testhexagonal.product.application.ports.input.UpdateProductUseCase;
import test.testhexagonal.product.application.ports.output.ProductRepository;
import test.testhexagonal.product.domain.model.Product;
import test.testhexagonal.product.domain.service.ProductService;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements CreateProductUseCase, ReadProductUseCase, UpdateProductUseCase, DeleteProductUseCase {

    private final ProductRepository productRepository;
    private final ProductService domainProductService;

    @Override
    public Mono<Product> createProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Mono<Product> getProduct(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public Flux<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Mono<Product> updateProduct(Product product) {
        // Utilizamos la lógica de negocio del servicio de dominio antes de guardar
        domainProductService.updatePrice(product, product.getPrice());
        return productRepository.save(product);
    }

    @Override
    public Mono<Void> deleteProduct(Long id) {
        return productRepository.deleteById(id);
    }
}
