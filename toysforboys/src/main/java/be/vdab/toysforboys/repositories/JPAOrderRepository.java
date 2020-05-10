package be.vdab.toysforboys.repositories;

import be.vdab.toysforboys.domain.Order;
import be.vdab.toysforboys.domain.Status;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

@Repository
public class JPAOrderRepository implements OrderRepository {

    private final EntityManager manager;

    public JPAOrderRepository(EntityManager manager) {
        this.manager = manager;
    }

    @Override
    public Optional<List<Order>> findUnshipped() {
        List<Order> orderList = manager.createQuery(
                "select o from Order o " +
                        "where o.status = :disputed " +
                        "or o.status = :processing " +
                        "or o.status = :resolved " +
                        "or o.status = :waiting", Order.class)
                .setParameter("disputed", Status.DISPUTED)
                .setParameter("processing", Status.PROCESSING)
                .setParameter("resolved", Status.RESOLVED)
                .setParameter("waiting", Status.WAITING)
                .getResultList();

        if (orderList.isEmpty()) return Optional.empty();

        return Optional.of(orderList);
    }

    @Override
    public Optional<Order> findById(long id) {
        return Optional.ofNullable(manager.find(Order.class, id));
    }
}
