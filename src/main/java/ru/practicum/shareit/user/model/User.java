package ru.practicum.shareit.user.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;            // уникальный идентификатор пользователя

    @Column(name = "name", nullable = false)
    private String name;        // имя или логин пользователя

    @Column(name = "email", nullable = false, unique = true)
    private String email;       // адрес электронной почты (два пользователя не могут иметь одинаковый email).
}
