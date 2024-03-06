package id.ac.ui.cs.advprog.eshop.model;

import id.ac.ui.cs.advprog.eshop.enums.PaymentMethod;
import id.ac.ui.cs.advprog.eshop.enums.PaymentStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PaymentTest {
    private List<Product> products;
    private Map<String, String> paymentData;
    private Order order;

    @BeforeEach
    void setUp(){
        this.paymentData = new HashMap<>();
        this.products = new ArrayList<>();
        Product product1 = new Product();
        product1.setProductId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        product1.setProductName("Sampo Cap Bambang");
        product1.setProductQuantity(2);
        Product product2 = new Product();
        product2.setProductId("a2c62328-4a37-4664-837c-f32db8620155");
        product2.setProductName("Sampo Cap Usep");
        product2.setProductQuantity(1);
        this.products.add(product1);
        this.products.add(product2);

        order= new Order(
                "13652556-012a-4c07-b546-54eb1396d79b",
                products,
                1708560000L,
                "Safira Sudrajat"
        );
    }

    void loadVoucherCodePaymentData() {
        paymentData.put("voucherCode", "ESHOP1234ABC5678");
    }
    void loadCashOnDeliveryPaymentData() {
        paymentData.put("address", "Temanggung, Selopampang");
        paymentData.put("deliveryFee", "70000");
    }

    @Test
    void createPaymentCashOnDeliveryWithNoOrder(){
        loadCashOnDeliveryPaymentData();
        assertThrows(IllegalArgumentException.class, () -> {
            new Payment("63dedbd6-c9a5-4074-bb78-72acb6b8f6f5", null, PaymentMethod.COD.getValue(), paymentData);
        });
        paymentData.clear();
    }

    @Test
    void createPaymentVoucherCodeWithNoOrder(){
        loadVoucherCodePaymentData();
        assertThrows(IllegalArgumentException.class, () -> {
            new Payment("63dedbd6-c9a5-4074-bb78-72acb6b8f6f5", null, PaymentMethod.VOUCHER.getValue(), paymentData);
        });
        paymentData.clear();
    }

    @Test
    void createPaymentCashOnDeliveryWithEmptyAddress(){
        loadCashOnDeliveryPaymentData();
        paymentData.put("address", "");
        Payment payment1 = new Payment("63dedbd6-c9a5-4074-bb78-72acb6b8f6f5", order, PaymentMethod.COD.getValue(), paymentData);
        payment1.processCODPayment(paymentData);
        assertEquals(payment1.getStatus(), PaymentStatus.REJECTED.getValue());
        paymentData.clear();
    }

    @Test
    void createPaymentCashOnDeliveryWithEmptyDeliveryFee(){
        loadCashOnDeliveryPaymentData();
        paymentData.put("deliveryFee", "");
        Payment payment1 = new Payment("63dedbd6-c9a5-4074-bb78-72acb6b8f6f5", order, PaymentMethod.COD.getValue(), paymentData);
        payment1.processCODPayment(paymentData);
        assertEquals(payment1.getStatus(), PaymentStatus.REJECTED.getValue());
        paymentData.clear();
    }

    @Test
    void createPaymentVoucherCodeWithInvalidCode(){
        loadVoucherCodePaymentData();
        paymentData.put("voucherCode", "INVALID_CODE");
        Payment payment1 = new Payment("63dedbd6-c9a5-4074-bb78-72acb6b8f6f5", order, PaymentMethod.COD.getValue(), paymentData);
        payment1.processVoucherPayment(paymentData.get("voucherCode"));
        assertEquals(payment1.getStatus(), PaymentStatus.REJECTED.getValue());
        paymentData.clear();
    }
    @Test
    void createPaymentVoucherCodeWithSuccessStatus(){
        loadVoucherCodePaymentData();
        Payment payment1 = new Payment("63dedbd6-c9a5-4074-bb78-72acb6b8f6f5", order, PaymentMethod.VOUCHER.getValue() , paymentData);
        payment1.processVoucherPayment(paymentData.get("voucherCode"));
        assertEquals(payment1.getStatus(), PaymentStatus.SUCCESS.getValue());
        paymentData.clear();
    }
    @Test
    void createPaymentCashOnDeliveryWithSuccessStatus(){
        loadCashOnDeliveryPaymentData();
        Payment payment1 = new Payment("63dedbd6-c9a5-4074-bb78-72acb6b8f6f5", order, PaymentMethod.COD.getValue(), paymentData);
        payment1.processCODPayment(paymentData);
        assertEquals(payment1.getStatus(), PaymentStatus.SUCCESS.getValue());
        paymentData.clear();
    }


}