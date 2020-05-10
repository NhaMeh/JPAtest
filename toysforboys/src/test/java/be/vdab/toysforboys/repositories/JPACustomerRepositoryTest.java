package be.vdab.toysforboys.repositories;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@Import(JPACustomerRepository.class)
public class JPACustomerRepositoryTest {
    @Autowired
    private JPACustomerRepository repository;

    @Test
    void findByNonExistingId() {
        assertThat(repository.findById(-1))
                .isNotPresent();
    }
}
