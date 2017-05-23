package builder;

import entities.Flight;

public class FlightBuilder {

    private Flight flight;

    FlightBuilder() {
        flight = new Flight();
        flight.setFrom("Bangalore");
        flight.setTo("New Delhi");
        flight.setDepartureDate("30 May 2017");
        flight.setAdults(2);
        flight.setClazz("Bussines");
    }

    public FlightBuilder withFrom(String from) {
        flight.setFrom(from);
        return this;
    }

    public FlightBuilder withTo(String to) {
        flight.setTo(to);
        return this;
    }

    public FlightBuilder withDepartureDate(String date) {
        flight.setDepartureDate(date);
        return this;
    }

    public FlightBuilder withAdults(int adults) {
        flight.setAdults(adults);
        return this;
    }
}
