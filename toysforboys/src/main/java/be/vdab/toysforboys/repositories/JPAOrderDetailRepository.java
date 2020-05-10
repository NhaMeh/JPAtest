package be.vdab.toysforboys.repositories;

import be.vdab.toysforboys.domain.OrderDetail;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

@Repository
public class JPAOrderDetailRepository implements OrderDetailRepository {
    private final EntityManager manager;

    public JPAOrderDetailRepository(EntityManager manager) {
        this.manager = manager;
    }

    @Override
    public Optional<List<OrderDetail>> findByOrderId(long orderId) {
        List<OrderDetail> orderDetailList = manager.createQuery(
                "select od from OrderDetail od where od.orderId = :orderid",
                OrderDetail.class)
                .setParameter("orderid", orderId)
                .getResultList();

        if (orderDetailList.isEmpty()) return Optional.empty();

        return Optional.of(orderDetailList);
    }

    @Override
    public Optional<OrderDetail> findByOrderIdAndProductId(long orderId, long productId) {
        List<OrderDetail> orderDetailList = manager.createQuery(
                "select od from OrderDetail od " +
                        "where od.orderId = :orderid and od.productId = :productid",
                OrderDetail.class)
                .setParameter("orderid", orderId)
                .setParameter("productid", productId)
                .getResultList();

        if (orderDetailList.isEmpty()) return Optional.empty();

        return Optional.of(orderDetailList.get(0));
    }
}
