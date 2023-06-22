package pe.upc.toybox_backend.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.upc.toybox_backend.entities.Payment;
import pe.upc.toybox_backend.repositories.PaymentRepository;

import java.util.List;

@Service
public class PaymentBusiness {
    @Autowired
    private PaymentRepository paymentRepository;
    @Transactional //register
    public Payment registerPayment(Payment payment) {
        return paymentRepository.save(payment);
    }
    //list
    public List<Payment> listPayment() {
        return paymentRepository.findAll();
    }
    //list Payment By ID
    public Payment listIdPayment(Long id) throws Exception{
        Payment payment= paymentRepository.findById(id).orElseThrow(() -> new Exception("No se encontró la entidad"));
        return payment;
    }
}
