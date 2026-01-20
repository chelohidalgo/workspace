package classes.dependencies;

import java.math.BigDecimal;

public class GoodOrderService {

    private final PaymentService paymentService;
    private final InventoryService inventoryService;

    public GoodOrderService(PaymentService paymentService, InventoryService inventoryService) {
        this.paymentService = paymentService;
        this.inventoryService = inventoryService;
    }

    public void processOrder(String orderId) {
        inventoryService.reserveItems(orderId);
        paymentService.processPayment(BigDecimal.valueOf(100));
        // other steps skipped for brevity
    }

}
