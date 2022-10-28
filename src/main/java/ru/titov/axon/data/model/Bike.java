package ru.titov.axon.data.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.Instant;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Bike {

    @Id
    private UUID id;
    private UUID renterId;
    private String name;
    private String description;
    private Instant createdAt;
    private boolean rented;
    private double mileage;

}
