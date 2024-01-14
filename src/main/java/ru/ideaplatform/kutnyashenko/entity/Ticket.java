package ru.ideaplatform.kutnyashenko.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonSetter;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;
import java.time.LocalTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class Ticket {

    private String origin;

    @JsonSetter("origin_name")
    private String originName;

    private String destination;

    @JsonSetter("destination_name")
    private String destinationName;

    @JsonSetter("departure_date")
    @JsonFormat(pattern = "dd.MM.yy")
    private LocalDate departureDate;

    @JsonSetter("departure_time")
    @JsonFormat(pattern = "H:mm")
    private LocalTime departureTime;

    @JsonSetter("arrival_date")
    @JsonFormat(pattern = "dd.MM.yy")
    private LocalDate arrivalDate;

    @JsonSetter("arrival_time")
    @JsonFormat(pattern = "H:mm")
    private LocalTime arrivalTime;

    private String carrier;

    private int stops;

    private double price;
}
