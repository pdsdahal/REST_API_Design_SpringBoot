package com.ecommerce.product_order_api.service;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import com.ecommerce.product_order_api.model.Product;
import com.ecommerce.product_order_api.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService, CommandLineRunner {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product addProduct(Product product) {
        productRepository.save(product);
        return product;
    }

    @Override
    public boolean deleteProduct(Long id) {
        if (!productRepository.existsById(id)) {
            return false;
        }
        productRepository.deleteById(id);
        return true;
    }

    @Override
    public Product getProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public Product updateProduct(Long id, Product product) {
        return productRepository.findById(id)
                .map(p -> {
                    p.setName(product.getName());
                    p.setPrice(product.getPrice());
                    p.setQuantity(product.getQuantity());
                    return productRepository.save(p);
                })
                .orElse(null);
    }

    @Override
    public void run(String... args) throws Exception {
        addProduct(new Product("iPhone", 999.99, 10));
        addProduct(new Product("Samsung Galaxy", 899.99, 8));
    }
}
