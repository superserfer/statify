package ch.linus.statify.services;

import ch.linus.statify.models.Activity;

import java.util.List;
import java.util.UUID;

public interface ActivityService extends CrudService<Activity, UUID> {
    List<Activity> getAllByUserId(UUID id);
}
