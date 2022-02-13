package ch.linus.statify.models.dto;

import ch.linus.statify.models.DailyStatistic;
import ch.linus.statify.models.User;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class FullUserDTO extends PartialUserDTO{
    protected List<DailyStatistic> dailyStatistics;

    public static FullUserDTO build(User user) {
        if (user==null) return null;
        FullUserDTO fullUserDTO = new FullUserDTO();
        fullUserDTO.userId = user.getUserId();
        fullUserDTO.firstName = user.getFirstName();
        fullUserDTO.lastName = user.getLastName();
        fullUserDTO.birthday = user.getBirthday();
        fullUserDTO.activities = user.getActivities();
        fullUserDTO.defaultProperties = user.getDefaultProperties();
        fullUserDTO.dailyStatistics = user.getDailyStatistics();
        return fullUserDTO;
    }
}
