package ch.linus.statify.controllers;

import ch.linus.statify.models.User;
import ch.linus.statify.models.dto.FullUserDTO;
import ch.linus.statify.models.dto.PartialUserDTO;
import ch.linus.statify.models.dto.UserDTO;
import ch.linus.statify.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public ResponseEntity<PartialUserDTO> getUserById(@PathVariable UUID id) {
        User user = this.userService.getById(id);
        return new ResponseEntity<>(PartialUserDTO.build(user), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<FullUserDTO> createUser(@RequestBody User user) {
        User createdUser = this.userService.create(user);
        return new ResponseEntity<>(FullUserDTO.build(createdUser), HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/{id}")
    public ResponseEntity<PartialUserDTO> updateUser(@PathVariable UUID id, @RequestBody UserDTO user) {
        PartialUserDTO updatedUser = PartialUserDTO.build(this.userService.update(id, User.builder()
                .birthday(user.getBirthday())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .build()));
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable UUID id) {
        this.userService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
