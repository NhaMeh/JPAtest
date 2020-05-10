package be.vdab.toysforboys.services;

import be.vdab.toysforboys.domain.Customer;
import be.vdab.toysforboys.repositories.CustomerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class DefaultCustomerServiceTest {
    private DefaultCustomerService service;
    @Mock
    private CustomerRepository repository;
    private Customer customer;

    @BeforeEach
    void beforeEach() {
        customer = new Customer(
                0L,
                "Jos",
                "street and number 38",
                "Brussel",
                null,
                "1000",
                0L,
                1L
        );
        service = new DefaultCustomerService(repository);
    }

    @Test
    void findCustomerNameById() {
        when(repository.findById(0)).thenReturn(Optional.of(customer));
        assertThat(service.findCustomerNameById(0))
                .isEqualTo("Jos");
    }
}
