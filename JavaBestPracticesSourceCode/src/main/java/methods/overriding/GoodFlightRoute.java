package methods.overriding;

import java.util.Objects;

public class GoodFlightRoute {

    private final String fromAirport;
    private final String toAirport;

    public GoodFlightRoute(String fromAirport, String toAirport) {
        this.fromAirport = fromAirport;
        this.toAirport = toAirport;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof GoodFlightRoute second)) {
            return false;
        }
        return Objects.equals(this.fromAirport, second.fromAirport) && Objects.equals(this.toAirport, second.toAirport);
    }

    public int hashCode() {
        return Objects.hash(fromAirport, toAirport);
    }

}
