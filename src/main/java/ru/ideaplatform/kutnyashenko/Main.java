package ru.ideaplatform.kutnyashenko;

import ru.ideaplatform.kutnyashenko.entity.Ticket;
import ru.ideaplatform.kutnyashenko.repository.Parse;
import ru.ideaplatform.kutnyashenko.service.TicketService;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

        List<Ticket> tickets = new Parse().parseJSON();
        TicketService ticketService = new TicketService();

        System.out.println(ticketService.getMinTimeBetweenTwoAirportsForAllCarrier(args[0], args[1], tickets));

        System.out.println(ticketService.getDifferenceBetweenAveragePriceAndMedianForTwoAirports(args[0], args[1], tickets));
    }
}
