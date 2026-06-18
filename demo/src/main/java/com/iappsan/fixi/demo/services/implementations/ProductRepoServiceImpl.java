package com.iappsan.fixi.demo.services.implementations;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.iappsan.fixi.demo.models.dto.Product;
import com.iappsan.fixi.demo.repositories.interfaces.ProductRepository;
import com.iappsan.fixi.demo.services.interfaces.ProductRepoService;

@Service
public class ProductRepoServiceImpl implements ProductRepoService{

    private final ProductRepository productRepository;

    // En vez de usar @Autowired, se puede inyectar el repositorio a través del constructor
    ProductRepoServiceImpl(@Qualifier("productRepositoryJson") ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Value("${tax.percentage}")
    private int taxPercentage;

    @Override
    public List<Product> findAll() {
        return productRepository.findAll()
        .stream()
        .map(p -> new Product(
            p.getId(), 
            p.getName(), 
            p.getDescription(), 
            p.getPrice() * (1 + taxPercentage / 100.0)))
        .collect(Collectors.toList());

        // También se puede hacer un clone
        // Product newP = (Product) p.clone();
        // newP.setPrice(newP.getPrice() * (1 + taxPercentage / 100.0)));
        // return newP;
    }

    @Override
    public Product getProductById(Long id) {
        return productRepository.getProductById(id);
    }
}
