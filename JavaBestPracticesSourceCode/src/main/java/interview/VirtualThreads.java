package interview;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.StructuredTaskScope;
import java.util.stream.IntStream;

public class VirtualThreads {

    public static void main(String[] args) {
        Instant start = Instant.now();
//        try {
//            traditionalThread();
//            simplestVirtualThread();
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }

//        newVirtualThreadWithExecutor();
//        timeDifferencesWithExecutor();
//        supportHugeNumberOfThreads();

        try {
            structuredConcurrencyAPI();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }

        Instant end = Instant.now();
        System.out.println("Total time: " + Duration.between(start, end).toMillis() + " ms");
    }

    private static void supportHugeNumberOfThreads() {
        try (var executor = Executors.newVirtualThreadPerTaskExecutor()) {
            IntStream.range(0, 1_000_000).forEach(i ->
                    executor.submit(() -> {
                        Thread.sleep(1000);
                        System.out.println("Task " + i + " done by " + Thread.currentThread());
                        return i;
                    })
            );
        }
    }

    private static void structuredConcurrencyAPI() throws InterruptedException, ExecutionException {
        try (var scope = new StructuredTaskScope.ShutdownOnFailure()) {
            var userTask = scope.fork(VirtualThreads::fetchUser);
            var orderTask = scope.fork(VirtualThreads::fetchOrder);

            scope.join();
            scope.throwIfFailed();

            System.out.println(userTask.get());
            System.out.println(orderTask.get());
        }

    }

    private static void timeDifferencesWithExecutor() {
        try (var executor = Executors.newVirtualThreadPerTaskExecutor()) {
            IntStream.range(0, 100).forEach(i ->
                    executor.submit(() -> {
                        Thread.sleep(500);
                        System.out.println("Task " + i + " running on " + Thread.currentThread());
                        return i;
                    })
            );
        } // Automatically waits for all tasks to finish

//        try (var executor = Executors.newFixedThreadPool(10)) {
//            IntStream.range(0, 100).forEach(i ->
//                    executor.submit(() -> {
//                        Thread.sleep(500);
//                        System.out.println("Task " + i + " running on " + Thread.currentThread());
//                        return i;
//                    })
//            );
//        } // Takes more time
    }

    private static void newVirtualThreadWithExecutor() {
        try (var executor = Executors.newVirtualThreadPerTaskExecutor()) {
            IntStream.range(0, 10000).forEach(i ->
                    executor.submit(() -> {
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        System.out.println("Task " + i + " done on " + Thread.currentThread());
                    })
            );
        }

    }

    private static void simplestVirtualThread() throws InterruptedException {
        Runnable task = () -> System.out.println("Running on " + Thread.currentThread());
        Thread vt = Thread.ofVirtual().start(task);
        vt.join();
    }

    private static void traditionalThread() throws InterruptedException {
        Runnable task = () -> System.out.println("Running on " + Thread.currentThread());
        Thread thread = new Thread(task);
        thread.start();
        thread.join();
    }

    record User(String name) {}
    record Cart(String id) {}
    record Order(String id) {}

    static User fetchUser() throws InterruptedException {
        Thread.sleep(200);
        return new User("Marcelo");
    }

    static Cart fetchCart() throws InterruptedException {
        Thread.sleep(300);
        return new Cart("C123");
    }

    static Order fetchOrder() throws InterruptedException {
        Thread.sleep(1000);
        return new Order("ORD-001");
    }

}
