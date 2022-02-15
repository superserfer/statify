package ch.linus.statify.repositories;

import ch.linus.statify.models.CustomProperty;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface CustomPropertyRepository extends CrudRepository<CustomProperty, UUID> {
     @Query("SELECT cp FROM CustomProperty cp WHERE cp.dailyStatistic.dailyStatsId = :id")
     List<CustomProperty> getByDailyStatisticId(@Param("id") UUID id);
}
