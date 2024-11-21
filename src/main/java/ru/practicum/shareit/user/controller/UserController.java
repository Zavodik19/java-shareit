package ru.practicum.shareit.user.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import ru.practicum.shareit.user.dto.UserDto;
import ru.practicum.shareit.user.service.UserService;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(path = "/users")
@RequiredArgsConstructor

public class UserController {
    private final UserService userService;

    @PostMapping
    public UserDto createUser(@Valid @RequestBody UserDto userDto) {
        log.info("Запрос на создание пользователя: {}", userDto);
        return userService.createUser(userDto);
    }

    @PatchMapping("/{userId}")
    public UserDto updateUser(@PathVariable Long userId, @RequestBody UserDto userDto) {
        log.info("Запрос на обновление пользователя с ID {}: {}", userId, userDto);
        return userService.updateUser(userId, userDto);
    }

    @GetMapping("/{userId}")
    public UserDto getUserById(@PathVariable Long userId) {
        log.info("Запрос на получение пользователя по ID: {}", userId);
        return userService.getUserById(userId);
    }

    @GetMapping
    public List<UserDto> getAllUsers() {
        log.info("Запрос на получение всех пользователей");
        return userService.getAllUsers();
    }

    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable Long userId) {
        log.info("Запрос на удаление пользователя по ID: {}", userId);
        userService.deleteUser(userId);
    }
}
