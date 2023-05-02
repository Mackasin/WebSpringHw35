package hm35.controller;

import hm35.entity.Order;
import hm35.service.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class OrderController {
    private final OrderRepository orderRepository;
    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Order> getOrderById(@PathVariable("id") int id){
        Order order=orderRepository.getById(id);
        if (order == null) {
            return ResponseEntity.notFound()
                    .build();
        } else {
            return ResponseEntity.ok(order);
        }
    }

    @PostMapping
    public ResponseEntity<Void> addOrder(@RequestBody Order order) {

        boolean inserted = orderRepository.insertOrder(order);

        if (inserted) {
            return ResponseEntity.status(HttpStatus.CREATED)
                    .build();
        } else {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .build();
        }
    }

    @GetMapping("/orders")
    public List<Order> getAllOrders() {
        return orderRepository.getAllOrders();
    }
}
