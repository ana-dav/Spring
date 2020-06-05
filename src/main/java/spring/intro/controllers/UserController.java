package spring.intro.controllers;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import spring.intro.UserResponseDto;
import spring.intro.model.User;
import spring.intro.service.interfaces.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/inject", method = RequestMethod.GET)
    public String inject() {
        userService.add(new User("bob@i.ua", "1234"));
        userService.add(new User("nick@i.ua", "1234"));
        userService.add(new User("kate@i.ua", "1234"));
        userService.add(new User("marie@i.ua", "1234"));
        return "4 users has been added successfully";
    }

    @RequestMapping(value = "/{userId}", method = RequestMethod.GET)
    public UserResponseDto get(@PathVariable Long userId) {
        return new UserResponseDto(userService.getById(userId));
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<UserResponseDto> getAll() {
        return userService.listUsers().stream()
                .map(UserResponseDto::new)
                .collect(Collectors.toList());
    }
}
