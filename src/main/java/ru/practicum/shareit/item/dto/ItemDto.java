package ru.practicum.shareit.item.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemDto {
    private Long id;                // уникальный идентификатор вещи

    @NotBlank(message = "Имя не может быть пустым")
    private String name;            // краткое название

    @NotBlank(message = "Описание не может быть пустым")
    private String description;     // развёрнутое описание

    @NotNull
    private Boolean available;      // статус о том, доступна или нет вещь для аренды

}
