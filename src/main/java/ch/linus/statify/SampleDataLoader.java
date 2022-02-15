package ch.linus.statify;

import ch.linus.statify.models.Activity;
import ch.linus.statify.models.DailyStatistic;
import ch.linus.statify.models.User;
import ch.linus.statify.models.customproperties.CustomBoolean;
import ch.linus.statify.models.customproperties.CustomNumber;
import ch.linus.statify.models.customproperties.CustomString;
import ch.linus.statify.services.ActivityService;
import ch.linus.statify.services.CustomPropertyService;
import ch.linus.statify.services.DailyStatisticService;
import ch.linus.statify.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.sql.Date;

@Component
public class SampleDataLoader implements CommandLineRunner {
    private final UserService userService;
    private final ActivityService activityService;
    private final CustomPropertyService customPropertyService;
    private final DailyStatisticService dailyStatisticService;

    @Autowired
    public SampleDataLoader(UserService userService, ActivityService activityService, CustomPropertyService customPropertyService, DailyStatisticService dailyStatisticService) {
        this.userService = userService;
        this.activityService = activityService;
        this.customPropertyService = customPropertyService;
        this.dailyStatisticService = dailyStatisticService;
    }

    @Override
    public void run(String... args) {
        loadData();
    }

    private void loadData() {
        if (this.userService.getAll().isEmpty()) {
            User user = this.userService.create(
                    User.builder()
                            .firstName("Max")
                            .lastName("Mustermann")
                            .birthday(new Date(1644787386389L))
                            .build()
            );

            this.activityService.create(Activity.builder()
                    .description("Learning")
                    .owner(null).build());

            this.activityService.create(
                    Activity.builder()
                            .description("Meet Friends")
                            .owner(user).build()
            );

            DailyStatistic dailyStatistic = this.dailyStatisticService.create(DailyStatistic.builder()
                    .date(new Date(10000000))
                    .user(user).build());

            CustomBoolean customBoolean = new CustomBoolean();
            customBoolean.setName("hasSleptGood");
            customBoolean.setBooleanValue(false);
            customBoolean.setUser(user);
            customBoolean.setDailyStatistic(dailyStatistic);
            this.customPropertyService.create(customBoolean);

            CustomNumber customNumber = new CustomNumber();
            customNumber.setName("Steps");
            customNumber.setIntValue(10_000);
            customNumber.setUser(user);
            customNumber.setDailyStatistic(dailyStatistic);
            this.customPropertyService.create(customNumber);

            CustomString customString = new CustomString();
            customString.setName("Meal");
            customString.setStringValue("I hope");
            customString.setUser(user);
            customString.setDailyStatistic(dailyStatistic);
            this.customPropertyService.create(customString);

            this.customPropertyService.deleteByDailyStatisticId(dailyStatistic.getDailyStatsId());
            System.out.println(user.getUserId());
        }
    }
}
