package ru.ideaplatform.kutnyashenko.entity;

import com.fasterxml.jackson.annotation.JsonSetter;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class TicketList {
    @JsonSetter("tickets")
    private List<Ticket> tickets;
}
