package ru.practicum.shareit.user.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long id;         // уникальный идентификатор пользователя

    @NotBlank(message = "Имя не может быть пустым")
    private String name;     // имя или логин пользователя

    @NotNull(message = "Email не может быть пустым")
    @Email(message = "Некорректный email")
    private String email;    // адрес электронной почты (два пользователя не могут иметь одинаковый email).
}
