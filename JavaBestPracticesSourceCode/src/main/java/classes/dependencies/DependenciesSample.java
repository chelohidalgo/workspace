package classes.dependencies;

class DependenciesSample {

    public static void main(String[] args) {
        System.out.println("-- BAD PRACTICE --");
        showBadPractice();

        System.out.println("\n-- GOOD PRACTICE --");
        showGoodPractice();
    }

    private static void showBadPractice() {
        BadOrderService orderService = new BadOrderService();
        orderService.processOrder("SampleId");
    }

    private static void showGoodPractice() {
        PaymentService paymentService = new PaymentService();
        InventoryService inventoryService = new InventoryService();
        GoodOrderService orderService = new GoodOrderService(paymentService, inventoryService);
        orderService.processOrder("SampleId");
    }


}
