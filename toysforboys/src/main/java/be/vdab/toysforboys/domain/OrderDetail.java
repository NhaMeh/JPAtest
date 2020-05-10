package be.vdab.toysforboys.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "orderdetails")
public class OrderDetail implements Serializable {
    @Id
    private long orderId;
    @Id
    private long productId;
    private long quantityOrdered;
    private BigDecimal priceEach;

    protected OrderDetail() {
    }

    public OrderDetail(long orderId, long productId, long quantityOrdered, BigDecimal priceEach) {
        this.orderId = orderId;
        this.productId = productId;
        this.quantityOrdered = quantityOrdered;
        this.priceEach = priceEach;
    }

    public long getOrderId() {
        return orderId;
    }

    public long getProductId() {
        return productId;
    }

    public long getQuantityOrdered() {
        return quantityOrdered;
    }

    public BigDecimal getPriceEach() {
        return priceEach;
    }
}
