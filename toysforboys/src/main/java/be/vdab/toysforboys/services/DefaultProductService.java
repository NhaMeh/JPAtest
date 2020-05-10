package be.vdab.toysforboys.services;

import be.vdab.toysforboys.domain.OrderDetail;
import be.vdab.toysforboys.domain.Product;
import be.vdab.toysforboys.exceptions.ProductNotFoundException;
import be.vdab.toysforboys.repositories.OrderDetailRepository;
import be.vdab.toysforboys.repositories.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = false, isolation = Isolation.READ_COMMITTED)
public class DefaultProductService implements ProductService {
    private final ProductRepository productRepository;
    private final OrderDetailRepository orderDetailRepository;

    public DefaultProductService(ProductRepository productRepository,
                                 OrderDetailRepository orderDetailRepository) {
        this.productRepository = productRepository;
        this.orderDetailRepository = orderDetailRepository;
    }

    @Override
    public Optional<Product> findById(long id) {
        return productRepository.findById(id);
    }

    @Override
    public List<Product> findByOrderId(long orderId) {
        if (orderDetailRepository.findByOrderId(orderId).isPresent()) {
            List<OrderDetail> orderDetails = orderDetailRepository.findByOrderId(orderId).get();
            List<Product> products = new ArrayList<>();

            for (OrderDetail orderDetail : orderDetails)
                products.add(productRepository.findById(orderDetail.getProductId()).get());

            return products;
        }

        return null;
    }

    @Override
    public void decreaseQuantityInOrder(long id, long quantity) {
        Optional<Product> optionalProduct = productRepository.findById(id);

        if (optionalProduct.isPresent())
            optionalProduct.get().setQuantityInOrder(optionalProduct.get().getQuantityInOrder() - quantity);
        else throw new ProductNotFoundException();
    }

    @Override
    public void decreaseQuantityInStock(long id, long quantity) {
        Optional<Product> optionalProduct = productRepository.findById(id);

        if (optionalProduct.isPresent())
            optionalProduct.get().setQuantityInStock(optionalProduct.get().getQuantityInStock() - quantity);
        else throw new ProductNotFoundException();
    }
}
