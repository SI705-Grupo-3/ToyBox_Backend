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
@RequestMapping("/api/order")
public class OrderController {
    @Autowired
    private OrderBusiness orderBusiness;
    @PostMapping("/register") //register
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
    @GetMapping("/list") //list
    public ResponseEntity<List<OrderDTO>> listOrder(){
        List<Order> list = orderBusiness.listOrder();
        List<OrderDTO> listDto = convertToLisDto(list);
        return new ResponseEntity<List<OrderDTO>>(listDto,HttpStatus.OK);
    }
    @GetMapping("/list/{id}") //list id
    public ResponseEntity<OrderDTO> listIdOrder(@PathVariable(value = "id") Long id){
        Order order;
        OrderDTO orderDTO;
        try {
            order = orderBusiness.listIdOrder(id);
            orderDTO = convertToDto(order);
            return new ResponseEntity<OrderDTO>(orderDTO, HttpStatus.OK);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No se pudo listar por id ...");
        }
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
