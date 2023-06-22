package pe.upc.toybox_backend.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.upc.toybox_backend.entities.Order;
import pe.upc.toybox_backend.repositories.OrderRepository;

import java.util.List;

@Service
public class OrderBusiness {
    @Autowired
    private OrderRepository orderRepository;
    @Transactional //register
    public Order registerOrder(Order order) {
        return orderRepository.save(order);
    }
    //list
    public List<Order> listOrder() {
        return orderRepository.findAll();
    }
    //list Order By ID
    public Order listIdOrder(Long id) throws Exception{
        Order order = orderRepository.findById(id).orElseThrow(() -> new Exception("No se encontró la entidad"));
        return order;
    }
}
