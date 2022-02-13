package ch.linus.statify;

import ch.linus.statify.models.User;
import ch.linus.statify.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.sql.Date;

@Component
public class SampleDataLoader implements CommandLineRunner {
    public final UserRepository userRepository;

    public SampleDataLoader(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) {
        loadUser();
    }

    private void loadUser() {
        if (this.userRepository.count() == 0) {
            User user = this.userRepository.save(
                    User.builder()
                            .firstName("Max")
                            .lastName("Mustermann")
                            .birthday(new Date(1644787386389L))
                            .build()
            );
            System.out.println(user.getUserId());
        }
    }
}
