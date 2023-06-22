package pe.upc.toybox_backend.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.upc.toybox_backend.entities.PaymentMethod;
import pe.upc.toybox_backend.repositories.PaymentMethodRepository;


import java.util.List;

@Service
public class PaymentMethodBusiness {
    @Autowired
    private PaymentMethodRepository paymentMethodRepository;
    @Transactional //register
    public PaymentMethod registerPaymentMethod(PaymentMethod paymentMethod) {
        return paymentMethodRepository.save(paymentMethod);
    }
    //list
    public List<PaymentMethod> listPaymentMethod() {
        return paymentMethodRepository.findAll();
    }
    @Transactional //update
    public PaymentMethod updatePaymentMethod(PaymentMethod paymentMethod) throws Exception{
        paymentMethodRepository.findById(paymentMethod.getId()).orElseThrow(() -> new Exception("No se encontró la entidad"));
        return paymentMethodRepository.save(paymentMethod);
    }
    @Transactional //delete
    public PaymentMethod deletePaymentMethod(Long id) throws Exception{
        PaymentMethod paymentMethod = paymentMethodRepository.findById(id).orElseThrow(() -> new Exception("No se encontró la entidad"));
        paymentMethodRepository.delete(paymentMethod);
        return paymentMethod;
    }
    //list Payment Method By ID
    public PaymentMethod listIdPaymentMethod(Long id) throws Exception{
        PaymentMethod paymentMethod = paymentMethodRepository.findById(id).orElseThrow(() -> new Exception("No se encontró la entidad"));
        return paymentMethod;
    }
}
