package pe.upc.toybox_backend.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import pe.upc.toybox_backend.business.OrderBusiness;
import pe.upc.toybox_backend.dtos.OrderDTO;
import pe.upc.toybox_backend.entities.Order;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class OrderController {
    @Autowired
    private OrderBusiness orderBusiness;
    @PostMapping("/order") //register
    public ResponseEntity<OrderDTO> registerOrder(@RequestBody OrderDTO orderDTO){
        Order order;
        try {
            order=convertToEntity(orderDTO);
            orderDTO=convertToDto(orderBusiness.registerOrder(order));
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"No fue posible registrarlo");
        }
        return new ResponseEntity<OrderDTO>(orderDTO, HttpStatus.OK);
    }
    @GetMapping("/orders") //list
    public ResponseEntity<List<OrderDTO>> listOrder(){
        List<Order> list = orderBusiness.listOrder();
        List<OrderDTO> listDto = convertToLisDto(list);
        return new ResponseEntity<List<OrderDTO>>(listDto,HttpStatus.OK);
    }

    private OrderDTO convertToDto(Order order) {
        ModelMapper modelMapper = new ModelMapper();
        OrderDTO orderDTO = modelMapper.map(order, OrderDTO.class);
        return orderDTO;
    }
    private Order convertToEntity(OrderDTO orderDTO) {
        ModelMapper modelMapper = new ModelMapper();
        Order post = modelMapper.map(orderDTO, Order.class);
        return post;
    }
    private List<OrderDTO> convertToLisDto(List<Order> list){
        return list.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }
}
