package ru.ideaplatform.kutnyashenko.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import ru.ideaplatform.kutnyashenko.entity.Ticket;
import ru.ideaplatform.kutnyashenko.entity.TicketList;

import java.io.IOException;
import java.util.List;

public class Parse {

    private final ObjectMapper objectMapper;

    public Parse() {
        this.objectMapper = new ObjectMapper().findAndRegisterModules();
    }

    public List<Ticket> parseJSON() throws IOException {
        return objectMapper.readValue(getClass().getResourceAsStream("/tickets.json"), TicketList.class).getTickets();
    }
}
