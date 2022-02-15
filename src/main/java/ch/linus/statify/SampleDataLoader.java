package ch.linus.statify;

import ch.linus.statify.models.Activity;
import ch.linus.statify.models.CustomProperty;
import ch.linus.statify.models.User;
import ch.linus.statify.models.customproperties.CustomBoolean;
import ch.linus.statify.models.customproperties.CustomString;
import ch.linus.statify.repositories.ActivityRepository;
import ch.linus.statify.repositories.UserRepository;
import ch.linus.statify.services.CustomPropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.sql.Date;

@Component
public class SampleDataLoader implements CommandLineRunner {
    private final UserRepository userRepository;
    private final ActivityRepository activityRepository;
    private final CustomPropertyService customPropertyService;

    @Autowired
    public SampleDataLoader(UserRepository userRepository, ActivityRepository activityRepository, CustomPropertyService customPropertyService) {
        this.userRepository = userRepository;
        this.activityRepository = activityRepository;
        this.customPropertyService = customPropertyService;
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

            Activity activity = this.activityRepository.save(Activity.builder()
                    .description("Learning")
                    .owner(null).build());

            this.activityRepository.save(
                    Activity.builder()
                            .description("Meet Friends")
                            .owner(user).build()
            );

            CustomBoolean customBoolean = new CustomBoolean();
            customBoolean.setName("hasSleptGood");
            customBoolean.setBooleanValue(false);
            customBoolean.setUser(user);
            CustomProperty customProperty = this.customPropertyService.create(customBoolean);

            System.out.println("User Id: " + user.getUserId());
            System.out.println("Activity Id: " + activity.getActivityId());
            System.out.println("CustomBoolean id: " + customProperty.getCustomPropertyId());
        }
    }
}
