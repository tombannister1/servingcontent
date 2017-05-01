package com.studios519.repository;
import org.springframework.data.repository.CrudRepository;
import com.studios519.model.Product;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

public interface ProductRepository extends  CrudRepository<Product, Long> {
    @Transactional
    Long deleteByid(Long id);
    List<Product> findByid(int id);
}
