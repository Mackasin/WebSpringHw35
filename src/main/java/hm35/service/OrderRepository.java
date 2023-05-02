package hm35.service;

import hm35.entity.Order;
import hm35.entity.Product;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderRepository {
    private List<Order> orders;

    public Order getById(int id) {
        return orders.stream()
                .filter(order -> order.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public List<Order> getAllOrders() {
        return orders;
    }

    public boolean insertOrder(Order order) {
        return orders.add(order);
    }
    @PostConstruct
    void initRepo() {
        orders = new ArrayList<>();
        Order order = new Order(66, LocalDate.now(),70.25,null);
        List<Product> products = new ArrayList<>();
        Product product1 = new Product(111,"Milk",39.50);
        Product product2 = new Product(101,"Bread",30.75);
        products.add(product1);
        products.add(product2);
        order.setProducts(products);
        orders.add(order);
    }

}
