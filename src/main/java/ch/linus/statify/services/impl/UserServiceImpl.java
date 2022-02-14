package ch.linus.statify.services.impl;

import ch.linus.statify.exceptions.NotFoundException;
import ch.linus.statify.models.User;
import ch.linus.statify.repositories.UserRepository;
import ch.linus.statify.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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
    public List<User> getAll() {
        return (List<User>) this.userRepository.findAll();
    }

    @Override
    public User getById(UUID id) {
        return getExistingUser(id);
    }

    @Override
    public User create(User entity) {
        return this.userRepository.save(entity);
    }

    @Override
    public User update(UUID id, User entity) {
        User user = getExistingUser(id);
        user.setBirthday(entity.getBirthday());
        user.setFirstName(entity.getFirstName());
        user.setLastName(entity.getLastName());
        return this.userRepository.save(user);
    }

    @Override
    public void deleteById(UUID id) {
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
