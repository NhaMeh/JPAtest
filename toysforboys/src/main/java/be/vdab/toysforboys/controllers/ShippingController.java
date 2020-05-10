package be.vdab.toysforboys.controllers;

import be.vdab.toysforboys.domain.Order;
import be.vdab.toysforboys.domain.Product;
import be.vdab.toysforboys.domain.Status;
import be.vdab.toysforboys.exceptions.NotEnoughStockException;
import be.vdab.toysforboys.services.OrderDetailService;
import be.vdab.toysforboys.services.OrderService;
import be.vdab.toysforboys.services.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("shipping")
public class ShippingController {
    private OrderService orderService;
    private ProductService productService;
    private OrderDetailService orderDetailService;

    public ShippingController(OrderService orderService,
                              ProductService productService,
                              OrderDetailService orderDetailService) {
        this.orderService = orderService;
        this.productService = productService;
        this.orderDetailService = orderDetailService;
    }

    @GetMapping
    public ModelAndView shipping() {
        return new ModelAndView("redirect:/");
    }

    public @PostMapping
    String ship(@RequestParam String orderList,
                RedirectAttributes redirect) {
        String[] orderIds = orderList.split(",");
        boolean insufficientStock = false;
        List<Long> failedOrders = new ArrayList<>();

        for (String s : orderIds) {
            long orderId = Long.parseLong(s);
            Order order = orderService.findById(orderId).get();
            List<Product> productList = productService.findByOrderId(order.getId());

            try {
                for (Product product : productList) {
                    long quantityOrdered = orderDetailService
                            .findByOrderIdAndProductId(orderId, product.getId())
                            .get()
                            .getQuantityOrdered();

                    if (product.getQuantityInStock() < quantityOrdered)
                        throw new NotEnoughStockException();

                    orderService.setStatus(orderId, Status.SHIPPED);
                    orderService.setShippedDate(orderId, LocalDate.now());

                    productService.decreaseQuantityInOrder(product.getId(), quantityOrdered);
                    productService.decreaseQuantityInStock(product.getId(), quantityOrdered);
                }
            } catch (NotEnoughStockException e) {
                e.printStackTrace();
                insufficientStock = true;
                failedOrders.add(orderId);
            }
        }

        if (insufficientStock) {
            redirect.addFlashAttribute("failedOrderIds", failedOrders);
        }

        return "redirect:/";
    }
}
