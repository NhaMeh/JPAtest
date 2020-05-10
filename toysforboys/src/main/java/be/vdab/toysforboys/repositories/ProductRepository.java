package be.vdab.toysforboys.repositories;

import be.vdab.toysforboys.domain.Product;

import java.util.Optional;

public interface ProductRepository {
    Optional<Product> findById(long id);
}
