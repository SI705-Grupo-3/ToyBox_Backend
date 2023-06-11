package pe.upc.toybox_backend.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import pe.upc.toybox_backend.business.OrderDetailBusiness;
import pe.upc.toybox_backend.dtos.OrderDetailDTO;
import pe.upc.toybox_backend.entities.OrderDetail;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api")
public class OrderDetailController {
    @Autowired
    private OrderDetailBusiness orderDetailBusiness;
    @PostMapping("/order-detail") //register
    public ResponseEntity<OrderDetailDTO> registerOrderDetail(@RequestBody OrderDetailDTO orderDetailDTO){
        OrderDetail orderDetail;
        try {
            orderDetail=convertToEntity(orderDetailDTO);
            orderDetailDTO=convertToDto(orderDetailBusiness.registerOrderDetail(orderDetail));
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"No fue posible registrarlo");
        }
        return new ResponseEntity<OrderDetailDTO>(orderDetailDTO, HttpStatus.OK);
    }
    @GetMapping("/order-details") //list
    public ResponseEntity<List<OrderDetailDTO>> listOrderDetail(){
        List<OrderDetail> list = orderDetailBusiness.listOrderDetail();
        List<OrderDetailDTO> listDto = convertToLisDto(list);
        return new ResponseEntity<List<OrderDetailDTO>>(listDto,HttpStatus.OK);
    }

    private OrderDetailDTO convertToDto(OrderDetail orderDetail) {
        ModelMapper modelMapper = new ModelMapper();
        OrderDetailDTO orderDetailDTO = modelMapper.map(orderDetail, OrderDetailDTO.class);
        return orderDetailDTO;
    }
    private OrderDetail convertToEntity(OrderDetailDTO orderDetailDTO) {
        ModelMapper modelMapper = new ModelMapper();
        OrderDetail post = modelMapper.map(orderDetailDTO, OrderDetail.class);
        return post;
    }
    private List<OrderDetailDTO> convertToLisDto(List<OrderDetail> list){
        return list.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }
}
