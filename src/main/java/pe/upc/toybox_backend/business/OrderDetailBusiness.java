package pe.upc.toybox_backend.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.upc.toybox_backend.entities.OrderDetail;
import pe.upc.toybox_backend.repositories.OrderDetailRepository;

import java.util.List;

@Service
public class OrderDetailBusiness {
    @Autowired
    private OrderDetailRepository orderDetailRepository;
    @Transactional //register
    public OrderDetail registerOrderDetail(OrderDetail orderDetail) {
        return orderDetailRepository.save(orderDetail);
    }
    //list
    public List<OrderDetail> listOrderDetail() {
        return orderDetailRepository.findAll();
    }

}
