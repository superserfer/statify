package ch.linus.statify.repositories;

import ch.linus.statify.models.Activity;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface ActivityRepository extends CrudRepository<Activity, UUID> {
}
