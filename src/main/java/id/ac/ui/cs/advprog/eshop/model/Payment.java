package id.ac.ui.cs.advprog.eshop.model;

import id.ac.ui.cs.advprog.eshop.enums.PaymentMethod;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;
import java.util.Map;

@Getter
public class Payment {
    String id;
    String method;
    Map<String, String> paymentData;
    Order order;
    @Setter
    String status;

    public Payment(String id, Order order, String method, Map<String, String> paymentData){
    }

    public Payment(String id, Order order, String method, Map<String, String> paymentData, String  status){
    }

}