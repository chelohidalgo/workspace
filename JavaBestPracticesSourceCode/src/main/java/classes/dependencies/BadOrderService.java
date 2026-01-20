package classes.dependencies;

import java.math.BigDecimal;

public class BadOrderService {

    private final PaymentService paymentService;
    private final InventoryService inventoryService;

    public BadOrderService() {
        this.paymentService = new PaymentService();
        this.inventoryService = new InventoryService();
    }

    public void processOrder(String orderId) {
        inventoryService.reserveItems(orderId);
        paymentService.processPayment(BigDecimal.valueOf(100));
        // other steps skipped for brevity
    }

}
