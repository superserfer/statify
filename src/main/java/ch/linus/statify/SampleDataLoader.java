package ch.linus.statify;

import ch.linus.statify.models.Activity;
import ch.linus.statify.models.User;
import ch.linus.statify.repositories.ActivityRepository;
import ch.linus.statify.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.sql.Date;

@Component
public class SampleDataLoader implements CommandLineRunner {
    private final UserRepository userRepository;
    private final ActivityRepository activityRepository;

    @Autowired
    public SampleDataLoader(UserRepository userRepository, ActivityRepository activityRepository) {
        this.userRepository = userRepository;
        this.activityRepository = activityRepository;
    }

    @Override
    public void run(String... args) {
        loadData();
    }

    private void loadData() {
        if (this.userRepository.count() == 0) {
            User user = this.userRepository.save(
                    User.builder()
                            .firstName("Max")
                            .lastName("Mustermann")
                            .birthday(new Date(1644787386389L))
                            .build()
            );
            System.out.println(user.getUserId());

            Activity activity = this.activityRepository.save(Activity.builder()
                    .description("Learning")
                    .owner(null).build());

            this.activityRepository.save(
                    Activity.builder()
                            .description("Meet Friends")
                            .owner(user).build()
            );

            System.out.println(this.activityRepository.findAllyByUserId(user.getUserId()).size());

            System.out.println(activity.getActivityId());
        }
    }
}
