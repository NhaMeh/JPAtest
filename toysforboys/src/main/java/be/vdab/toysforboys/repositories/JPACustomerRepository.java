package be.vdab.toysforboys.repositories;

import be.vdab.toysforboys.domain.Customer;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.Optional;

@Repository
public class JPACustomerRepository implements CustomerRepository {
    private final EntityManager manager;

    public JPACustomerRepository(EntityManager manager) {
        this.manager = manager;
    }

    @Override
    public Optional<Customer> findById(long id) {
        return Optional.ofNullable(manager.find(Customer.class, id));
    }
}
