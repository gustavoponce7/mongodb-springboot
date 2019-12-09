package com.gpch.mongo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
@Document(collection = "reservations")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Reservation {
    @Id
    private String id;
    @NotBlank(message="Please provide a name.")
    private String name;
    @DateTimeFormat(pattern="dd-MM-yyyy HH:mm")
    @NotNull(message="Please provide a date whit the format dd-MM-yyyy HH:mm")
    private LocalDateTime date;
}
