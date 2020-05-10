package be.vdab.toysforboys.services;

import be.vdab.toysforboys.domain.Order;
import be.vdab.toysforboys.domain.Status;
import be.vdab.toysforboys.exceptions.OrderNotFoundException;
import be.vdab.toysforboys.repositories.OrderRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = false, isolation = Isolation.READ_COMMITTED)
public class DefaultOrderService implements OrderService {
    private final OrderRepository orderRepository;

    DefaultOrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Optional<List<Order>> findUnshipped() {
        return orderRepository.findUnshipped();
    }

    @Override
    public Optional<Order> findById(long id) {
        return orderRepository.findById(id);
    }

    @Override
    public void setStatus(long id, Status status) {
        Optional<Order> optionalOrder = orderRepository.findById(id);

        if (optionalOrder.isPresent())
            optionalOrder.get().setStatus(status);
        else throw new OrderNotFoundException();
    }

    @Override
    public void setShippedDate(long id, LocalDate date) {
        Optional<Order> optionalOrder = orderRepository.findById(id);

        if (optionalOrder.isPresent())
            optionalOrder.get().setShippedDate(date);
        else throw new OrderNotFoundException();
    }
}
