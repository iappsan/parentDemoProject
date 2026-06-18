package com.iappsan.fixi.demo.repositories.implementations;

import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import org.springframework.web.context.annotation.RequestScope;

import com.iappsan.fixi.demo.models.dto.Product;
import com.iappsan.fixi.demo.repositories.interfaces.ProductRepository;

@Primary
// El ciclo de vida del repositorio es por petición, lo que significa que se creará una nueva instancia del repositorio para cada petición HTTP. 
// Esto es útil para evitar problemas de concurrencia y garantizar que cada petición tenga su propia instancia del repositorio.
// También existe @SessionScope, que mantiene la misma instancia del repositorio durante toda la sesión del usuario,
// lo que puede ser útil para almacenar datos específicos del usuario durante su sesión.
@RequestScope
@Repository("productRepository")
public class ProductRepositoryImpl implements ProductRepository {

    private List<Product> productsData;

    public ProductRepositoryImpl() {
        this.productsData = List.of(
            new Product(1L, "Memoria RAM", "Memoria de 16 GB", 3000.0),
            new Product(2L, "Ryzen 7", "Procesador AMD Ryzen 7", 3120.0),
            new Product(3L, "Ventilador", "Ventilador de CPU", 88.0),
            new Product(4L, "Tarjeta de video", "Tarjeta de video NVIDIA", 16000.0)
        );
    }

    @Override
    public List<Product> findAll() {
        return productsData;
    }

    @Override
    public Product getProductById(Long id) {
        return productsData.stream()
            .filter(product -> product.getId().equals(id))
            .findFirst()
            .orElse(null);
    }

}
