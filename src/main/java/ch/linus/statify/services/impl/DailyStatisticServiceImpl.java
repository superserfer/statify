package ch.linus.statify.services.impl;

import ch.linus.statify.exceptions.NotFoundException;
import ch.linus.statify.models.DailyStatistic;
import ch.linus.statify.repositories.DailyStatisticRepository;
import ch.linus.statify.services.CustomPropertyService;
import ch.linus.statify.services.DailyStatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class DailyStatisticServiceImpl implements DailyStatisticService {
    private final DailyStatisticRepository dailyStatisticRepository;
    private final CustomPropertyService customPropertyService;

    @Autowired
    public DailyStatisticServiceImpl(DailyStatisticRepository dailyStatisticRepository, CustomPropertyService customPropertyService) {
        this.dailyStatisticRepository = dailyStatisticRepository;
        this.customPropertyService = customPropertyService;
    }

    @Override
    public DailyStatistic create(DailyStatistic newEntity) {
        newEntity.setDailyStatsId(null);
        DailyStatistic dailyStatistic = this.dailyStatisticRepository.save(newEntity);
        newEntity.getCustomProperties().forEach(customProperty -> {
            customProperty.setDailyStatistic(dailyStatistic);
            this.customPropertyService.create(customProperty);
        });
        return dailyStatistic;
    }

    @Override
    public DailyStatistic getById(UUID id) {
        return getExistingDailyStatistic(id);
    }

    @Override
    public List<DailyStatistic> getAll() {
        return (List<DailyStatistic>) this.dailyStatisticRepository.findAll();
    }

    @Override
    public DailyStatistic update(UUID id, DailyStatistic entity) {
        DailyStatistic dailyStatistic = getExistingDailyStatistic(id);
        dailyStatistic.setDate(entity.getDate());
        dailyStatistic.setActivities(entity.getActivities());

        entity.getCustomProperties().forEach(customProperty -> {
            customProperty.setDailyStatistic(entity);
            this.customPropertyService.update(customProperty.getCustomPropertyId(), customProperty);
        });

        return this.dailyStatisticRepository.save(dailyStatistic);
    }

    @Override
    public void deleteById(UUID id) {
        this.dailyStatisticRepository.deleteById(id);
    }

    private DailyStatistic getExistingDailyStatistic(UUID id) {
        // TODO: Fix Relations and remove line beneath
        this.dailyStatisticRepository.findAll();
        Optional<DailyStatistic> optionalDailyStatistic = this.dailyStatisticRepository.findById(id);
        if (optionalDailyStatistic.isEmpty()) throw new NotFoundException();
        return optionalDailyStatistic.get();
    }
}
