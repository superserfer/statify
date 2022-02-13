package ch.linus.statify.services;

import ch.linus.statify.models.User;

import java.util.UUID;

public interface UserService {
    User getUser(UUID id);

    User createUser(User user);

    User updateUser(UUID id, User user);

    void deleteUser(UUID id);
}
