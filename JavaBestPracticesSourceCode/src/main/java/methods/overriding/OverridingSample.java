package methods.overriding;

import java.util.HashSet;
import java.util.Set;

public class OverridingSample {

    public static void main(String[] args) {
        System.out.println("-- BAD PRACTICE --");
        showBadPractice();

        System.out.println("\n-- GOOD PRACTICE --");
        showGoodPractice();
    }

    private static void showBadPractice() {
        Set<BadFlightRoute> routes = new HashSet<>();
        for (int i = 0; i < 10; i++) {
            routes.add(new BadFlightRoute("WAW", "CDG"));
        }
        System.out.println("Number of routes: " + routes.size());
    }

    private static void showGoodPractice() {
        Set<GoodFlightRoute> routes = new HashSet<>();
        for (int i = 0; i < 10; i++) {
            routes.add(new GoodFlightRoute("WAW", "CDG"));
        }
        System.out.println("Number of routes: " + routes.size());
    }

}
