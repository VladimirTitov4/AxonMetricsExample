package ru.titov.axon.projection;

import lombok.RequiredArgsConstructor;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Service;
import ru.titov.axon.cqrs.bike.event.BikeCreatedEvent;
import ru.titov.axon.cqrs.bike.event.BikeDeletedEvent;
import ru.titov.axon.cqrs.bike.event.BikeRentedEvent;
import ru.titov.axon.cqrs.bike.event.BikeReturnedEvent;
import ru.titov.axon.cqrs.bike.event.BikeUpdatedEvent;
import ru.titov.axon.data.model.Bike;
import ru.titov.axon.data.model.EntityMapper;
import ru.titov.axon.data.repository.BikeRepository;

import javax.persistence.EntityNotFoundException;

@Service
@RequiredArgsConstructor
public class BikeProjection {

    private final EntityMapper mapper;
    private final BikeRepository repository;

    @EventHandler
    public void on(BikeCreatedEvent event) {
        repository.save(mapper.map(event));
    }

    @EventHandler
    public void on(BikeRentedEvent event) {
        Bike bike = repository.findById(event.getId())
                .orElseThrow(() -> new EntityNotFoundException("Bike with id not found " + event.getId()));
        bike.setRented(true);
        bike.setRenterId(event.getRenterId());
        repository.save(bike);
    }

    @EventHandler
    public void on(BikeReturnedEvent event) {
        Bike bike = repository.findById(event.getId())
                .orElseThrow(() -> new EntityNotFoundException("Bike with id not found " + event.getId()));
        bike.setRented(false);
        bike.setRenterId(null);
        repository.save(bike);
    }

    @EventHandler
    public void on(BikeUpdatedEvent event) {
        Bike bikeFromDb = repository.findById(event.getId())
                .orElseThrow(() -> new EntityNotFoundException("Bike with id not found " + event.getId()));
        Bike bikeFromEvent = mapper.map(event);

        Bike result = mapper.merge(bikeFromEvent, bikeFromDb);
        repository.save(result);
    }

    @EventHandler
    public void on(BikeDeletedEvent event) {
        repository.deleteById(event.getId());
    }
}
