package ch.linus.statify.repositories;

import ch.linus.statify.models.Activity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface ActivityRepository extends CrudRepository<Activity, UUID> {
    @Query("SELECT a FROM Activity a WHERE a.owner.userId = :userId")
    List<Activity> findAllyByUserId(@Param("userId") UUID userId);
}
