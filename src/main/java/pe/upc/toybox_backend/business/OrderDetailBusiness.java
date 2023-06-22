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
    //list Order Detail By ID
    public OrderDetail listIdOrderDetail(Long id) throws Exception{
        OrderDetail orderDetail = orderDetailRepository.findById(id).orElseThrow(() -> new Exception("No se encontró la entidad"));
        return orderDetail;
    }
}
