package ch.linus.statify.services.impl;

import ch.linus.statify.exceptions.NotFoundException;
import ch.linus.statify.models.Activity;
import ch.linus.statify.repositories.ActivityRepository;
import ch.linus.statify.services.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ActivityServiceImpl implements ActivityService {
    private final ActivityRepository activityRepository;

    @Autowired
    public ActivityServiceImpl(ActivityRepository activityRepository) {
        this.activityRepository = activityRepository;
    }

    @Override
    public List<Activity> getAllByUserId(UUID id) {
        return this.activityRepository.findAllyByUserId(id);
    }

    @Override
    public Activity create(Activity newEntity) {
        return this.activityRepository.save(newEntity);
    }

    @Override
    public Activity getById(UUID id) {
        return getExistingActivity(id);
    }

    @Override
    public List<Activity> getAll() {
        return (List<Activity>) this.activityRepository.findAll();
    }

    @Override
    public Activity update(UUID id, Activity entity) {
        Activity activity = getExistingActivity(id);
        activity.setDescription(entity.getDescription());
        return this.activityRepository.save(activity);
    }

    @Override
    public void deleteById(UUID id) {
        this.activityRepository.deleteById(id);
    }

    private Activity getExistingActivity(UUID id) {
        // TODO: Fix Relations and remove line beneath
        this.activityRepository.findAll();
        Optional<Activity> optionalActivity = this.activityRepository.findById(id);
        if (optionalActivity.isEmpty()) throw new NotFoundException();
        return optionalActivity.get();
    }

}

