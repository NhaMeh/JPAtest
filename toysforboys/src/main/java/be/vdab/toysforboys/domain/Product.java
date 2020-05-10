package be.vdab.toysforboys.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;
import java.math.BigDecimal;

@Entity
@Table(name = "products")
public class Product {
    @Id
    private long id;
    private String name, scale, description;
    private long quantityInStock, quantityInOrder, productlineId;
    private BigDecimal buyPrice;
    @Version
    private long version;

    protected Product() {
    }

    public Product(long id,
                   String name,
                   String scale,
                   String description,
                   long quantityInStock,
                   long quantityInOrder,
                   long productlineId,
                   BigDecimal buyPrice,
                   long version) {
        this.id = id;
        this.name = name;
        this.scale = scale;
        this.description = description;
        this.quantityInStock = quantityInStock;
        this.quantityInOrder = quantityInOrder;
        this.productlineId = productlineId;
        this.buyPrice = buyPrice;
        this.version = version;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getScale() {
        return scale;
    }

    public String getDescription() {
        return description;
    }

    public long getQuantityInStock() {
        return quantityInStock;
    }

    public long getQuantityInOrder() {
        return quantityInOrder;
    }

    public long getProductlineId() {
        return productlineId;
    }

    public BigDecimal getBuyPrice() {
        return buyPrice;
    }

    public long getVersion() {
        return version;
    }

    public void setQuantityInStock(long quantityInStock) {
        this.quantityInStock = quantityInStock;
    }

    public void setQuantityInOrder(long quantityInOrder) {
        this.quantityInOrder = quantityInOrder;
    }
}
