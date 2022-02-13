package ch.linus.statify.services.impl;

import ch.linus.statify.exceptions.NotFoundException;
import ch.linus.statify.models.User;
import ch.linus.statify.repositories.UserRepository;
import ch.linus.statify.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User getUser(UUID id) {
        return getExistingUser(id);
    }

    @Override
    public User createUser(User newUser) {
        return this.userRepository.save(newUser);
    }

    @Override
    public User updateUser(UUID id, User updatedUser) {
        User user = getExistingUser(id);
        user.setBirthday(updatedUser.getBirthday());
        user.setFirstName(updatedUser.getFirstName());
        user.setLastName(updatedUser.getLastName());
        return this.userRepository.save(user);
    }

    @Override
    public void deleteUser(UUID id) {
        this.userRepository.deleteById(id);
    }

    private User getExistingUser(UUID id) {
        // TODO: Fix Relations and remove line beneath
        this.userRepository.findAll();
        Optional<User> optionalUser = this.userRepository.findById(id);
        if (optionalUser.isEmpty()) throw new NotFoundException();
        return optionalUser.get();
    }
}
