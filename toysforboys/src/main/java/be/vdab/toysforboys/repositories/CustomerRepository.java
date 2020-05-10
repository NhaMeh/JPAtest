package be.vdab.toysforboys.repositories;

import be.vdab.toysforboys.domain.Customer;

import java.util.Optional;

public interface CustomerRepository {
    Optional<Customer> findById(long id);
}
