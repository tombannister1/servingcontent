package com.studios519.service;
import com.studios519.model.Product;
/**
 * Created by tomba on 21/03/2017.
 */
public interface ProductService {
    public void saveProduct(Product product);
    public void update(Product product);
    public void deleteByid(Long id);
    public void findByid(int id);
}
