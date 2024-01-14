package ru.ideaplatform.kutnyashenko.service;

import ru.ideaplatform.kutnyashenko.entity.Ticket;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.OptionalDouble;

public class TicketService {


    public Map<String, Long> getMinTimeBetweenTwoAirportsForAllCarrier(String origin,
                                                                       String destination, List<Ticket> tickets) {

        Map<String, Long> result = new HashMap<>();

        for (Ticket ticket : tickets) {
            if (origin.toUpperCase().equals(ticket.getOrigin())
                    && destination.toUpperCase().equals(ticket.getDestination())) {

                LocalDateTime originDataTime = LocalDateTime.of(ticket.getArrivalDate(), ticket.getArrivalTime());
                LocalDateTime destinationDataTime = LocalDateTime.of(ticket.getDepartureDate(), ticket.getDepartureTime());

                long flightTime = Duration.between(destinationDataTime.toLocalTime(),
                        originDataTime.toLocalTime()).toMinutes();

                if (result.containsKey(ticket.getCarrier())){
                    if(result.get(ticket.getCarrier()) > flightTime){
                        result.put(ticket.getCarrier(), flightTime);
                    }
                } else {
                    result.put(ticket.getCarrier(), flightTime);
                }
            }
        }
        return result;
    }

    public double getDifferenceBetweenAveragePriceAndMedianForTwoAirports(String origin,
                                                                          String destination, List<Ticket> tickets) {
        List<Double> pricesBetweenTwoAirports = tickets.stream()
                .filter(ticket -> ticket.getOrigin().equals(origin.toUpperCase()))
                .filter(ticket -> ticket.getDestination().equals(destination.toUpperCase()))
                .map(Ticket::getPrice)
                .sorted().toList();

        int middlePriceList = pricesBetweenTwoAirports.size() / 2;

        double medianPrice = (
                pricesBetweenTwoAirports.size() % 2 == 0 ?
                        (pricesBetweenTwoAirports.get(middlePriceList) + pricesBetweenTwoAirports.get(middlePriceList - 1)) / 2 :
                        pricesBetweenTwoAirports.get(middlePriceList)
        );

        OptionalDouble averagePrice = pricesBetweenTwoAirports.stream().mapToDouble(x -> x).average();

        return Math.abs(medianPrice - averagePrice.getAsDouble());
    }
}
