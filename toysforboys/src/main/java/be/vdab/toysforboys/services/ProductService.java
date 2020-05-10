package be.vdab.toysforboys.services;

import be.vdab.toysforboys.domain.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    Optional<Product> findById(long id);

    List<Product> findByOrderId(long id);

    void decreaseQuantityInOrder(long id, long quantity);

    void decreaseQuantityInStock(long id, long quantity);
}
