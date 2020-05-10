package be.vdab.toysforboys.services;

import be.vdab.toysforboys.domain.Order;
import be.vdab.toysforboys.domain.Status;
import be.vdab.toysforboys.repositories.OrderRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class DefaultOrderServiceTest {
    private DefaultOrderService service;
    @Mock
    private OrderRepository repository;
    private Order order;
    private final static LocalDate ORDERDATE = LocalDate.of(2008, 07, 06);
    private final static LocalDate REQUIREDDATE = LocalDate.of(2008, 10, 06);
    private final static LocalDate SHIPPEDDATE = LocalDate.of(2008, 8, 26);

    @BeforeEach
    void beforeEach() {
        order = new Order(
                0L,
                ORDERDATE,
                REQUIREDDATE,
                null,
                "some comments",
                1L,
                Status.WAITING,
                1L
        );
        service = new DefaultOrderService(repository);
    }

    @Test
    void setShippedStatus() {
        when(repository.findById(0)).thenReturn(Optional.of(order));
        service.setStatus(0, Status.SHIPPED);
        assertThat(service.findById(0).get().getStatus())
                .isEqualTo(Status.SHIPPED);
    }

    @Test
    void setShippedDate() {
        when(repository.findById(0)).thenReturn(Optional.of(order));
        service.setShippedDate(0, SHIPPEDDATE);
        assertThat(service.findById(0).get().getShippedDate())
                .isEqualTo(SHIPPEDDATE);
    }
}
