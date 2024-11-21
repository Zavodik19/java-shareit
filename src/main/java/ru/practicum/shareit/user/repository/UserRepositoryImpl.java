package ru.practicum.shareit.user.repository;

import org.springframework.stereotype.Repository;
import ru.practicum.shareit.exception.NotFoundException;
import ru.practicum.shareit.user.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;


@Repository
public class UserRepositoryImpl implements UserRepository {
    private final Map<Long, User> users = new HashMap<>();
    private long currentId = 1;

    @Override
    public User createUser(User user) {
        user.setId(currentId++);
        users.put(user.getId(), user);
        return user;
    }

    @Override
    public User updateUser(User user) {
        if (!users.containsKey(user.getId())) {
            throw new NotFoundException("Пользователь с таким ID не найден");
        }
        users.put(user.getId(), user);
        return user;
    }

    @Override
    public List<User> getAllUsers() {
        return new ArrayList<>(users.values());
    }

    @Override
    public Optional<User> getUserById(Long userId) {
        return Optional.ofNullable(users.get(userId));
    }

    @Override
    public void deleteUser(Long userId) {
        if (!users.containsKey(userId)) {
            throw new NotFoundException("Пользователь с таким ID не найден");
        }
        users.remove(userId);
    }

    @Override
    public Boolean existsByEmail(String email) {
        return users.values().stream().anyMatch(user -> user.getEmail().equals(email));
    }
}
