package ch.linus.statify.repositories;

import ch.linus.statify.models.DailyStatistic;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface DailyStatisticRepository extends CrudRepository<DailyStatistic, UUID> {
}
