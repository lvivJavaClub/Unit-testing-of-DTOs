package ua.lviv.javaclub.validation;


import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
  @PostMapping(path = "/users")
  void createUser(@Valid @RequestBody UserDTO userDto) {
    // create a user using the UserService
  }
}
