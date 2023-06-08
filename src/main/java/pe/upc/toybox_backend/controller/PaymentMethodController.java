package pe.upc.toybox_backend.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import pe.upc.toybox_backend.business.PaymentMethodBusiness;
import pe.upc.toybox_backend.dtos.PaymentMethodDTO;
import pe.upc.toybox_backend.entities.PaymentMethod;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api")
public class PaymentMethodController {
    @Autowired
    private PaymentMethodBusiness paymentMethodBusiness;
    @PostMapping("/payment-method") //register
    public ResponseEntity<PaymentMethodDTO> registerPaymentMethod(@RequestBody PaymentMethodDTO paymentMethodDTO){
        PaymentMethod paymentMethod;
        try {
            paymentMethod=convertToEntity(paymentMethodDTO);
            paymentMethodDTO=convertToDto(paymentMethodBusiness.registerPaymentMethod(paymentMethod));
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"No fue posible registrarlo");
        }
        return new ResponseEntity<PaymentMethodDTO>(paymentMethodDTO, HttpStatus.OK);
    }
    @GetMapping("/payment-methods") //list
    public ResponseEntity<List<PaymentMethodDTO>> listPaymentMethod(){
        List<PaymentMethod> list = paymentMethodBusiness.listPaymentMethod();
        List<PaymentMethodDTO> listDto = convertToLisDto(list);
        return new ResponseEntity<List<PaymentMethodDTO>>(listDto,HttpStatus.OK);
    }
    @PutMapping("/payment-method") //update
    public ResponseEntity<PaymentMethodDTO> updatePaymentMethod(@RequestBody PaymentMethodDTO pym) {
        PaymentMethodDTO paymentMethodDTO;
        PaymentMethod paymentMethod;
        try {
            paymentMethod= convertToEntity(pym);
            paymentMethod = paymentMethodBusiness.updatePaymentMethod(paymentMethod);
            paymentMethodDTO = convertToDto(paymentMethod);
            return new ResponseEntity<PaymentMethodDTO>(paymentMethodDTO, HttpStatus.OK);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No se pudo actualizar ...");
        }
    }
    @DeleteMapping("/payment-method/{id}") //delete
    public ResponseEntity<PaymentMethodDTO> deletePaymentMethod(@PathVariable(value = "id") Long id){
        PaymentMethod paymentMethod;
        PaymentMethodDTO paymentMethodDTO;
        try {
            paymentMethod = paymentMethodBusiness.deletePaymentMethod(id);
            paymentMethodDTO = convertToDto(paymentMethod);
            return new ResponseEntity<PaymentMethodDTO>(paymentMethodDTO, HttpStatus.OK);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No se pudo eliminar ...");
        }
    }
    private PaymentMethodDTO convertToDto(PaymentMethod paymentMethod) {
        ModelMapper modelMapper = new ModelMapper();
        PaymentMethodDTO paymentMethodDTO = modelMapper.map(paymentMethod, PaymentMethodDTO.class);
        return paymentMethodDTO;
    }
    private PaymentMethod convertToEntity(PaymentMethodDTO paymentMethodDTO) {
        ModelMapper modelMapper = new ModelMapper();
        PaymentMethod post = modelMapper.map(paymentMethodDTO, PaymentMethod.class);
        return post;
    }
    private List<PaymentMethodDTO> convertToLisDto(List<PaymentMethod> list){
        return list.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }
}
