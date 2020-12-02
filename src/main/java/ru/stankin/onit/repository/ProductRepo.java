package ru.stankin.onit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.stankin.onit.model.Product;
import java.util.List;

public interface ProductRepo extends JpaRepository<Product, Long> {
    List<Product> findByName(String name);
}
