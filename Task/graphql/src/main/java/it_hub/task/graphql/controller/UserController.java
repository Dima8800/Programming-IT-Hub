package it_hub.task.graphql.controller;

import it_hub.task.graphql.model.Car;
import it_hub.task.graphql.model.User;
import it_hub.task.graphql.service.UserService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @QueryMapping
    public User user(@Argument Long id) {
        return userService.getUser(id);
    }

    @QueryMapping
    public List<User> users() {
        return userService.getAllUsers();
    }

    @MutationMapping
    public User addUser(@Argument String name, @Argument String surname, @Argument String phone) {
        return userService.addUser(name, surname, phone);
    }

    @MutationMapping
    public Car addCar(
            @Argument Long userId,
            @Argument String brand,
            @Argument String model,
            @Argument String color,
            @Argument double engine) {
        return userService.addCar(userId, brand, model, color, engine);
    }
}
