package com.gpch.mongo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Data
@Document(collection = "reservations")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Reservation {
    @Id
    private String id;
    private String name;
    @DateTimeFormat(pattern="dd-MM-yyyy HH:mm")
    private LocalDateTime date;
}
