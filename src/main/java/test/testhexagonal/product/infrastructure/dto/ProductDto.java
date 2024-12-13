package test.testhexagonal.product.infrastructure.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class ProductDto {
    private Long id;
    private String name;
    private Double price;
}
