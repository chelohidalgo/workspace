package methods.overriding;

import java.util.Objects;

public class BadFlightRoute {

    private final String fromAirport;
    private final String toAirport;

    public BadFlightRoute(String fromAirport, String toAirport) {
        this.fromAirport = fromAirport;
        this.toAirport = toAirport;
    }

    public boolean equals(BadFlightRoute second) {
        return Objects.equals(this.fromAirport, second.fromAirport) && Objects.equals(this.toAirport, second.toAirport);
    }

    public int hashCode() {
        return Objects.hash(fromAirport, toAirport);
    }

}
