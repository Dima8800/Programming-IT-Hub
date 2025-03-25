package it_hub.task.graphql.repository;

import it_hub.task.graphql.model.Car;
import it_hub.task.graphql.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class UserRepository {
    private final Map<Long, User> userStorage = new HashMap<>();
    private Long currentId = 1L;

    public User save(User user) {
        user.setId(currentId++);
        userStorage.put(user.getId(), user);
        return user;
    }

    public User findById(Long id) {
        return userStorage.get(id);
    }

    public List<User> findAll() {
        return new ArrayList<>(userStorage.values());
    }

    public void addCar(Long userId, Car car) {
        User user = userStorage.get(userId);
        if (user != null) {
            user.getCars().add(car);
        }
    }
}