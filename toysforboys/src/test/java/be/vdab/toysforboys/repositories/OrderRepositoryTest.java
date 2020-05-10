package be.vdab.toysforboys.repositories;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class OrderRepositoryTest {
    @Mock
    private OrderRepository repository;

    @Test
    void findUnshippedShouldBeEmpty() {
        when(repository.findUnshipped()).thenReturn(Optional.empty());
        assertThat(repository.findUnshipped())
                .isNotPresent();
    }
}
