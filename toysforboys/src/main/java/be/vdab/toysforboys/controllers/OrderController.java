package be.vdab.toysforboys.controllers;

import be.vdab.toysforboys.domain.Customer;
import be.vdab.toysforboys.domain.Order;
import be.vdab.toysforboys.domain.OrderDetail;
import be.vdab.toysforboys.domain.Product;
import be.vdab.toysforboys.services.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("order")
public class OrderController {
    private OrderService orderService;
    private CustomerService customerService;
    private CountryService countryService;
    private ProductService productService;
    private OrderDetailService orderDetailService;

    public OrderController(OrderService orderService,
                           CustomerService customerService,
                           CountryService countryService,
                           ProductService productService,
                           OrderDetailService orderDetailService) {
        this.orderService = orderService;
        this.customerService = customerService;
        this.countryService = countryService;
        this.productService = productService;
        this.orderDetailService = orderDetailService;
    }

    @GetMapping
    public ModelAndView order() {
        return new ModelAndView("redirect:/");
    }

    @GetMapping("{id}")
    public ModelAndView order(@PathVariable long id) {
        // get out
        if (!orderService.findById(id).isPresent()) return new ModelAndView("redirect:/");

        Order order = orderService.findById(id).get();

        // get out
        if (!customerService.findById(order.getCustomerId()).isPresent())
            return new ModelAndView("redirect:/");

        Customer customer = customerService.findById(order.getCustomerId()).get();
        String countryName = countryService.findCountryNameById(customer.getCountryId());
        List<Product> products = productService.findByOrderId(order.getId());
        Map<Product, Long> productsAndOrderedQuantity = new LinkedHashMap<>();
        BigDecimal total = BigDecimal.ZERO;

        for (Product product : products) {
            OrderDetail orderDetail = orderDetailService.findByOrderIdAndProductId(
                    order.getId(), product.getId()).get();

            productsAndOrderedQuantity.put(product, orderDetail.getQuantityOrdered());
            total = total.add(product.getBuyPrice().multiply(
                    BigDecimal.valueOf(orderDetail.getQuantityOrdered())));
        }

        return new ModelAndView("order", "order", order)
                .addObject("customer", customer)
                .addObject("countryName", countryName)
                .addObject("productsAndOrderedQuantity", productsAndOrderedQuantity)
                .addObject("total", total);
    }
}
