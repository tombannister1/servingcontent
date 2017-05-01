package com.studios519.service;
import java.util.Arrays;
import java.util.HashSet;

import com.studios519.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.studios519.model.Role;
import com.studios519.model.Product;
import com.studios519.repository.ProductRepository;
import com.studios519.service.ProductService;
import org.springframework.transaction.annotation.Transactional;
@Service("productService")
@Transactional
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepository productRepository;

    @Override
    public void saveProduct(Product product) {
        product.setName(product.getName());
        product.setDescription(product.getDescription());
        product.setLive(1);
        productRepository.save(product);
    }

    public void update(Product product) {
        product.setName(product.getName());
        product.setDescription(product.getDescription());
        product.setLive(1);
        productRepository.save(product);
    }

    @Override
    public void deleteByid(Long id){
        productRepository.deleteByid(id);
    }
    @Override
    public void findByid(int id){
        productRepository.findByid(id);
    }


}