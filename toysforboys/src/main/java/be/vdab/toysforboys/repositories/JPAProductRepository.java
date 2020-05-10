package be.vdab.toysforboys.repositories;

import be.vdab.toysforboys.domain.Product;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.Optional;

@Repository
public class JPAProductRepository implements ProductRepository {
    private final EntityManager manager;

    public JPAProductRepository(EntityManager manager) {
        this.manager = manager;
    }

    @Override
    public Optional<Product> findById(long id) {
        return Optional.ofNullable(manager.find(Product.class, id));
    }
}
