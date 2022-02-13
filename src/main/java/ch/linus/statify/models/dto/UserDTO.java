package ch.linus.statify.models.dto;

import ch.linus.statify.models.User;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
import java.util.UUID;

@Getter
@Setter
public class UserDTO {
    protected UUID userId;
    protected String firstName;
    protected String lastName;
    protected Date birthday;

    public static UserDTO build(User user) {
        if (user==null) return null;
        UserDTO userDTO = new UserDTO();
        userDTO.userId = user.getUserId();
        userDTO.firstName = user.getFirstName();
        userDTO.lastName = user.getLastName();
        userDTO.birthday = user.getBirthday();
        return userDTO;
    }
}
