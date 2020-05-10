package be.vdab.toysforboys.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

class ProductTest {
    private Product product;
    private final static BigDecimal BUYPRICE = BigDecimal.valueOf(84.3);
    private final static long QUANTITYINSTOCK = 100L;
    private final static long QUANTITYINORDER = 20L;

    @BeforeEach
    void beforeEach() {
        product = new Product(0L,
                "test product",
                "1:2",
                "test product to test with",
                QUANTITYINSTOCK,
                QUANTITYINORDER,
                1L,
                BUYPRICE,
                1L);
    }

    @Test
    void setQuantityInStockIncreaseBy10() {
        product.setQuantityInStock(product.getQuantityInStock() + 10L);
        assertThat(product.getQuantityInStock())
                .isEqualTo(110L);
    }

    @Test
    void setQuantityinstockDecreaseBy10(){
        product.setQuantityInStock(product.getQuantityInStock() - 10L);
        assertThat(product.getQuantityInStock())
                .isEqualTo(90L);
    }
}
