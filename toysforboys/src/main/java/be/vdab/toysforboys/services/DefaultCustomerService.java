package be.vdab.toysforboys.services;

import be.vdab.toysforboys.domain.Customer;
import be.vdab.toysforboys.repositories.CustomerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED)
public class DefaultCustomerService implements CustomerService {
    private final CustomerRepository customerRepository;

    public DefaultCustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Optional<Customer> findById(long id) {
        return customerRepository.findById(id);
    }

    @Override
    public String findCustomerNameById(long id) {
        Optional<Customer> optionalCustomer = customerRepository.findById(id);

        return optionalCustomer.map(Customer::getName).orElse(null);
    }
}
