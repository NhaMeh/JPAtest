package be.vdab.toysforboys.repositories;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@Import(JPAOrderDetailRepository.class)
public class JPAOrderDetailRepositoryTest {
    @Autowired
    private JPAOrderDetailRepository repository;

    @Test
    void findByNonExistingOrderId() {
        assertThat(repository.findByOrderId(-1))
                .isNotPresent();
    }

    @Test
    void findByNonExistingProductIdAndOrderId() {
        assertThat(repository.findByOrderIdAndProductId(-1, -1))
                .isNotPresent();
    }
}
