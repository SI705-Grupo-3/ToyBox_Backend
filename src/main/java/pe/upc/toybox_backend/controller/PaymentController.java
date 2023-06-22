package pe.upc.toybox_backend.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import pe.upc.toybox_backend.business.PaymentBusiness;
import pe.upc.toybox_backend.dtos.PaymentDTO;
import pe.upc.toybox_backend.entities.Payment;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin
@RequestMapping("/api/payment")
public class PaymentController {
    @Autowired
    private PaymentBusiness paymentBusiness;
    @PostMapping("/register") //register
    public ResponseEntity<PaymentDTO> registerPayment(@RequestBody PaymentDTO paymentDTO){
        Payment payment;
        try {
            payment=convertToEntity(paymentDTO);
            paymentDTO=convertToDto(paymentBusiness.registerPayment(payment));
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"No fue posible registrarlo");
        }
        return new ResponseEntity<PaymentDTO>(paymentDTO, HttpStatus.OK);
    }
    @GetMapping("/list") //list
    public ResponseEntity<List<PaymentDTO>> listPayment(){
        List<Payment> list = paymentBusiness.listPayment();
        List<PaymentDTO> listDto = convertToLisDto(list);
        return new ResponseEntity<List<PaymentDTO>>(listDto,HttpStatus.OK);
    }
    @GetMapping("/list/{id}") //list id
    public ResponseEntity<PaymentDTO> listIdPayment(@PathVariable(value = "id") Long id){
        Payment payment;
        PaymentDTO paymentDTO;
        try {
            payment = paymentBusiness.listIdPayment(id);
            paymentDTO = convertToDto(payment);
            return new ResponseEntity<PaymentDTO>(paymentDTO, HttpStatus.OK);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No se pudo listar por id ...");
        }
    }
    private PaymentDTO convertToDto(Payment payment) {
        ModelMapper modelMapper = new ModelMapper();
        PaymentDTO paymentDTO = modelMapper.map(payment, PaymentDTO.class);
        return paymentDTO;
    }
    private Payment convertToEntity(PaymentDTO paymentDTO) {
        ModelMapper modelMapper = new ModelMapper();
        Payment post = modelMapper.map(paymentDTO, Payment.class);
        return post;
    }
    private List<PaymentDTO> convertToLisDto(List<Payment> list){
        return list.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }
}
