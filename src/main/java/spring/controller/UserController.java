package spring.controller;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import spring.dto.UserResponseDto;
import spring.model.User;
import spring.service.interfaces.UserService;

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

    @GetMapping("/{userId}")
    public UserResponseDto get(@PathVariable Long userId) {
        return getUserResponseDto(userService.getById(userId));
    }

    @GetMapping
    public List<UserResponseDto> getAll() {
        return userService.listUsers().stream()
                .map((this::getUserResponseDto))
                .collect(Collectors.toList());
    }

    private UserResponseDto getUserResponseDto(User user) {
        UserResponseDto dto = new UserResponseDto();
        dto.setEmail(user.getEmail());
        dto.setPassword(user.getPassword());
        return dto;
    }
}
