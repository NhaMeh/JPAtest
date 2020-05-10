package be.vdab.toysforboys.repositories;

import be.vdab.toysforboys.domain.OrderDetail;

import java.util.List;
import java.util.Optional;

public interface OrderDetailRepository {
    Optional<List<OrderDetail>> findByOrderId(long orderId);

    Optional<OrderDetail> findByOrderIdAndProductId(long orderId, long productId);
}
