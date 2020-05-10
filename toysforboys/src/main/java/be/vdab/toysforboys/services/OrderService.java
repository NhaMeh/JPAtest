package be.vdab.toysforboys.services;

import be.vdab.toysforboys.domain.Order;
import be.vdab.toysforboys.domain.Status;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface OrderService {
    Optional<List<Order>> findUnshipped();

    Optional<Order> findById(long id);

    void setStatus(long id, Status status);

    void setShippedDate(long id, LocalDate date);
}
