package test.testhexagonal.product.domain.service;

import org.springframework.stereotype.Service;
import test.testhexagonal.product.domain.model.Product;

@Service
public class ProductService {

    public void updatePrice(Product product, Double newPrice) {
        product.setPrice(newPrice);
    }
}
