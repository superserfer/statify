package ch.linus.statify.repositories;

import ch.linus.statify.models.CustomProperty;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CustomPropertyRepository extends CrudRepository<CustomProperty, UUID> {
}
