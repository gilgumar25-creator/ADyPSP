package com.salesianos.dam.primerejemplo.utils;

import com.salesianos.dam.primerejemplo.model.Category;
import com.salesianos.dam.primerejemplo.model.Product;
import com.salesianos.dam.primerejemplo.repo.ProductRepository;
import com.salesianos.dam.primerejemplo.service.CategoryService;
import com.salesianos.dam.primerejemplo.service.ProductService;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class DataSeed {

    private final CategoryService categoryService;
    private final ProductService productService;

    @PostConstruct
    public void initData() {

        if (ProductRepository.count() > 0) {
            return;
        }

        Category tecnologia = categoryService.addCategory(
                Category.builder().name("Tecnología").build());
        Category hogar = categoryService.addCategory(
                Category.builder().name("Hogar").build());
        Category deportes = categoryService.addCategory(
                Category.builder().name("Deportes").build());

        ProductRepository.saveAll(List.of(
                Product.builder().name("Portátil 15\"").price(799.99)
                        .details("Portátil con 16 GB de RAM y SSD de 512 GB")
                        .category(tecnologia).build(),
                Product.builder().name("Auriculares Bluetooth").price(59.90)
                        .details("Auriculares inalámbricos con cancelación de ruido")
                        .category(tecnologia).build(),
                Product.builder().name("Aspirador robot").price(249.00)
                        .details("Aspirador con mapeo láser y app móvil")
                        .category(hogar).build(),
                Product.builder().name("Lámpara de escritorio").price(24.95)
                        .details("Lámpara LED regulable con puerto USB")
                        .category(hogar).build(),
                Product.builder().name("Balón de fútbol").price(19.99)
                        .details("Balón talla 5 homologado")
                        .category(deportes).build(),
                Product.builder().name("Esterilla de yoga").price(15.50)
                        .details("Esterilla antideslizante de 6 mm")
                        .category(deportes).build()
        ));
    }
}