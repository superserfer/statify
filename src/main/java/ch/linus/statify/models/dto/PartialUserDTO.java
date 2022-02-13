package ch.linus.statify.models.dto;

import ch.linus.statify.models.Activity;
import ch.linus.statify.models.CustomProperty;
import ch.linus.statify.models.User;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PartialUserDTO extends UserDTO{
    protected List<Activity> activities;
    protected List<CustomProperty> defaultProperties;

    public static PartialUserDTO build(User user) {
        if (user==null) return null;
        PartialUserDTO partialUserDTO = new PartialUserDTO();
        partialUserDTO.userId = user.getUserId();
        partialUserDTO.firstName = user.getFirstName();
        partialUserDTO.lastName = user.getLastName();
        partialUserDTO.birthday = user.getBirthday();
        partialUserDTO.activities = user.getActivities();
        partialUserDTO.defaultProperties = user.getDefaultProperties();
        return partialUserDTO;
    }
}
