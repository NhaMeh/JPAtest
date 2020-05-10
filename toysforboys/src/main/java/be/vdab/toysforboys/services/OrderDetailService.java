package be.vdab.toysforboys.services;

import be.vdab.toysforboys.domain.OrderDetail;

import java.util.List;
import java.util.Optional;

public interface OrderDetailService {
    Optional<List<OrderDetail>> findByOrderId(long orderId);

    Optional<OrderDetail> findByOrderIdAndProductId(long orderId, long productId);
}
