package be.vdab.toysforboys.services;

import be.vdab.toysforboys.domain.OrderDetail;
import be.vdab.toysforboys.repositories.OrderDetailRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED)
public class DefaultOrderDetailService implements OrderDetailService {
    private final OrderDetailRepository orderDetailRepository;

    public DefaultOrderDetailService(OrderDetailRepository orderDetailRepository) {
        this.orderDetailRepository = orderDetailRepository;
    }

    @Override
    public Optional<List<OrderDetail>> findByOrderId(long orderId) {
        return orderDetailRepository.findByOrderId(orderId);
    }

    @Override
    public Optional<OrderDetail> findByOrderIdAndProductId(long orderId, long productId) {
        return orderDetailRepository.findByOrderIdAndProductId(orderId, productId);
    }
}
