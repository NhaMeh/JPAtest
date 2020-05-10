package be.vdab.toysforboys.controllers;

import be.vdab.toysforboys.domain.Order;
import be.vdab.toysforboys.forms.ShippingForm;
import be.vdab.toysforboys.services.CustomerService;
import be.vdab.toysforboys.services.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;


@Controller
@RequestMapping("/")
public class IndexController {
    private final OrderService orderService;
    private final CustomerService customerService;

    public IndexController(OrderService orderService,
                           CustomerService customerService) {
        this.orderService = orderService;
        this.customerService = customerService;
    }

    @GetMapping
    public ModelAndView index() {
        Optional<List<Order>> orderOptional = orderService.findUnshipped();

        if (orderOptional.isPresent()) {
            Map<Order, String> orderAndCustomer = new LinkedHashMap<>();
            List<Order> orderList = orderOptional.get();

            for (Order order : orderList)
                orderAndCustomer.put(order, customerService.findCustomerNameById(order.getCustomerId()));

            return new ModelAndView("index", "unshippedOrders", orderAndCustomer)
                    .addObject(new ShippingForm());
        }

        return new ModelAndView("index", "unshippedOrders", null);
    }
}
