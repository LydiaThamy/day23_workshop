package sg.nus.edu.iss.day23_workshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sg.nus.edu.iss.day23_workshop.model.Order;
import sg.nus.edu.iss.day23_workshop.repository.OrderRepo;

@Service
public class OrderService {

    @Autowired
    private OrderRepo repository;

    public Order getOrder(Integer orderId) {
        return repository.getOrder(orderId);
    }
}
