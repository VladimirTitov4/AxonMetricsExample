package ru.titov.axon.data.input.bike;

import lombok.Value;

import java.util.UUID;

@Value
public class UpdateBikeInput {
    UUID bikeId;
    String name;
    String description;
}
