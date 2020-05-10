package be.vdab.toysforboys.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

public class OrderTest {
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
    }

    @Test
    void setShippedDate() {
        order.setShippedDate(SHIPPEDDATE);
        assertThat(order.getShippedDate())
                .isEqualTo(SHIPPEDDATE);
    }

    @Test
    void setShippedStatus() {
        order.setStatus(Status.SHIPPED);
        assertThat(order.getStatus())
                .isEqualTo(Status.SHIPPED);
    }
}
