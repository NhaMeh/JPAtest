package be.vdab.toysforboys.services;

import be.vdab.toysforboys.domain.OrderDetail;
import be.vdab.toysforboys.domain.Product;
import be.vdab.toysforboys.repositories.OrderDetailRepository;
import be.vdab.toysforboys.repositories.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class DefaultProductServiceTest {
    private DefaultProductService service;
    @Mock
    private ProductRepository productRepository;
    @Mock
    private OrderDetailRepository orderDetailRepository;
    private OrderDetail orderDetail;
    private Product product;
    private List<OrderDetail> orderDetailList = new ArrayList<>();
    private final static BigDecimal BUYPRICE = BigDecimal.valueOf(84.3);
    private final static long QUANTITYINSTOCK = 100L;
    private final static long QUANTITYINORDER = 20L;

    @BeforeEach
    void beforeEach() {
        orderDetail = new OrderDetail(
                1L,
                1L,
                8L,
                BigDecimal.TEN
        );
        product = new Product(1L,
                "test product",
                "1:2",
                "test product to test with",
                QUANTITYINSTOCK,
                QUANTITYINORDER,
                1L,
                BUYPRICE,
                1L);
        service = new DefaultProductService(productRepository, orderDetailRepository);
        orderDetailList.add(orderDetail);
    }

    @Test
    void findByOrderId() {
        when(productRepository.findById(1)).thenReturn(Optional.of(product));
        when(orderDetailRepository.findByOrderId(1)).thenReturn(Optional.of(orderDetailList));
        assertThat(service.findByOrderId(1).get(0))
                .isEqualTo(product);
    }
}
