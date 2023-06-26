package sg.nus.edu.iss.day23_workshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.context.request.WebRequest;

import sg.nus.edu.iss.day23_workshop.service.OrderService;

@Controller
public class OrderController {

    @Autowired
    private OrderService service;

    @GetMapping("/order/total/{orderId}")
    public Object getOrder(@PathVariable Integer orderId, Model m, WebRequest request) {
        m.addAttribute("order", service.getOrder(orderId));
        return "order-total";
    }
    
}
