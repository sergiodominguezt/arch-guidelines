package test.testhexagonal.product.infrastructure.adapters.input;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;
import test.testhexagonal.common.controller.AbstractRestController;
import test.testhexagonal.common.dto.ResponseDTO;
import test.testhexagonal.product.application.ports.input.CreateProductUseCase;
import test.testhexagonal.product.application.ports.input.DeleteProductUseCase;
import test.testhexagonal.product.application.ports.input.ReadProductUseCase;
import test.testhexagonal.product.application.ports.input.UpdateProductUseCase;
import test.testhexagonal.product.domain.model.Product;
import test.testhexagonal.product.infrastructure.dto.ProductDto;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController extends AbstractRestController {
    private final CreateProductUseCase createProductUseCase;
    private final ReadProductUseCase readProductUseCase;
    private final UpdateProductUseCase updateProductUseCase;
    private final DeleteProductUseCase deleteProductUseCase;
    private final ModelMapper modelMapper;

    @PostMapping
    public Mono<ResponseEntity<ResponseDTO>> createProduct(@RequestBody ProductDto productDto) {
        return Mono.just(productDto)
                .map(dto -> modelMapper.map(dto, Product.class))
                .flatMap(createProductUseCase::createProduct)
                .map(product -> buildSuccessResponseDTO(modelMapper.map(product, ProductDto.class)))
                .map(responseDTO -> new ResponseEntity<>(responseDTO, HttpStatus.OK));
    }

    @GetMapping("/{id}")
    public Mono<ResponseEntity<ResponseDTO>> getProduct(@PathVariable Long id) {
        return readProductUseCase.getProduct(id)
                .map(product -> buildSuccessResponseDTO(modelMapper.map(product, ProductDto.class)))
                .map(responseDTO -> new ResponseEntity<>(responseDTO, HttpStatus.OK));
    }

    @GetMapping
    public Mono<ResponseEntity<ResponseDTO>> getAllProducts() {
        return readProductUseCase.getAllProducts()
                .map(product -> modelMapper.map(product, ProductDto.class)) // Mapea cada producto
                .collectList() // Recolecta todos los productos en una lista
                .map(this::buildSuccessResponseDTO) // Construye la respuesta
                .map(responseDTO -> new ResponseEntity<>(responseDTO, HttpStatus.OK)); // Crea el ResponseEntity
    }

    @PutMapping("/{id}")
    public Mono<ResponseEntity<ResponseDTO>> updateProduct(@PathVariable Long id, @RequestBody ProductDto productDto) {
        return Mono.just(productDto)
                .map(dto -> modelMapper.map(dto, Product.class))
                .doOnNext(product -> product.setId(id))
                .flatMap(updateProductUseCase::updateProduct)
                .map(updatedProduct -> buildSuccessResponseDTO(modelMapper.map(updatedProduct, ProductDto.class)))
                .map(responseDTO -> new ResponseEntity<>(responseDTO, HttpStatus.OK));
    }

    @DeleteMapping("/{id}")
    public Mono<ResponseEntity<ResponseDTO>> deleteProduct(@PathVariable Long id) {
        return deleteProductUseCase.deleteProduct(id)
                .then(Mono.fromSupplier(() -> {
                    ResponseDTO responseDTO = buildSuccessResponseDTO("Product deleted successfully");
                    return new ResponseEntity<>(responseDTO, HttpStatus.OK);
                }));
    }
}
