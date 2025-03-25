package it_hub.task.graphql.service;

import it_hub.task.graphql.model.Car;
import it_hub.task.graphql.model.User;
import it_hub.task.graphql.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User addUser(String name, String surname, String phone) {
        User user = new User(null, name, surname, phone, new ArrayList<>());
        return userRepository.save(user);
    }

    public User getUser(Long id) {
        return userRepository.findById(id);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Car addCar(Long userId, String brand, String model, String color, Double engine) {
        Car car = new Car(brand, model, color, engine);
        userRepository.addCar(userId, car);
        return car;
    }
}
