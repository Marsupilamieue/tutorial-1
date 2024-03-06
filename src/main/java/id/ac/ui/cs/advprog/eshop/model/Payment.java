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
        this.id = id;
        this.order = order;
        this.method = method;
        this.paymentData = paymentData;
        this.status = "WAITING_PAYMENT";

        if (order == null) {
            throw new IllegalArgumentException("Order must not be null");
        }

        if (paymentData == null || paymentData.isEmpty()) {
            throw new IllegalArgumentException("Payment data must not be null or empty");
        }

        if (!PaymentMethod.contains(method)) {
            throw new IllegalArgumentException("Invalid payment method");
        }
    }

    public Payment(String id, Order order, String method, Map<String, String> paymentData, String  status){
        this(id,order,method,paymentData);

        String[] statusList = {"WAITING_PAYMENT", "REJECTED", "SUCCESS", "FAILED"};
        if(Arrays.stream(statusList).noneMatch(item -> (item.equals(status)))){
            throw new IllegalArgumentException();
        }else{
            this.status = status;
        }
    }

    public void setStatus(String status){
        String[] statusList = {"WAITING_PAYMENT", "REJECTED", "SUCCESS", "FAILED"};
        if(Arrays.stream(statusList).noneMatch(item -> (item.equals(status)))){
            throw new IllegalArgumentException();
        }else{
            this.status = status;
        }
    }

    public void processVoucherPayment(String voucherCode) {
        if (voucherCode.length() != 16 || !voucherCode.startsWith("ESHOP") || !voucherCode.substring(5).matches("\\d{4}[A-Z]{3}\\d{4}")) {
            this.status = "REJECTED";
        }else{
            this.status = "SUCCESS";
        }
    }

    public void processCODPayment(Map<String, String> paymentData) {
        String address = paymentData.get("address");
        String deliveryFee = paymentData.get("deliveryFee");

        if (address == null || address.isEmpty() || deliveryFee == null || deliveryFee.isEmpty()) {
            this.status = "REJECTED";
        }else {
            this.status = "SUCCESS";
        }
    }

}