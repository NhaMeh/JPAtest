package be.vdab.toysforboys.domain;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    private long id;
    private long customerId;
    @Version
    private long version;
    private LocalDate orderDate, requiredDate, shippedDate;
    private String comments;
    @Enumerated(EnumType.STRING)
    private Status status;

    protected Order() {
    }

    public Order(long id,
                 LocalDate orderDate,
                 LocalDate requiredDate,
                 LocalDate shippedDate,
                 String comments,
                 long customerId,
                 Status status,
                 long version) {
        this.id = id;
        this.orderDate = orderDate;
        this.requiredDate = requiredDate;
        this.shippedDate = shippedDate;
        this.comments = comments;
        this.customerId = customerId;
        this.status = status;
        this.version = version;
    }

    public long getId() {
        return id;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public LocalDate getRequiredDate() {
        return requiredDate;
    }

    public LocalDate getShippedDate() {
        return shippedDate;
    }

    public String getComments() {
        return comments;
    }

    public long getCustomerId() {
        return customerId;
    }

    public Status getStatus() {
        return status;
    }

    public long getVersion() {
        return version;
    }

    public void setVersion(long version) {
        this.version = version;
    }

    public void setShippedDate(LocalDate shippedDate) {
        this.shippedDate = shippedDate;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
