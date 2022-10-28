package ru.titov.axon.data.model;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import ru.titov.axon.cqrs.bike.event.BikeCreatedEvent;
import ru.titov.axon.cqrs.bike.event.BikeUpdatedEvent;
import ru.titov.axon.cqrs.renter.event.RenterCreatedEvent;
import ru.titov.axon.cqrs.renter.event.RenterUpdatedEvent;

@Mapper
public interface EntityMapper {

    Bike map(BikeCreatedEvent event);

    Bike map(BikeUpdatedEvent event);

    Bike merge(Bike bikeFromEvent, @MappingTarget Bike bikeFromDb);

    Renter map(RenterCreatedEvent event);

    Renter map(RenterUpdatedEvent event);

    Renter merge(Renter renterFromEvent, @MappingTarget Renter renterFromDb);

}