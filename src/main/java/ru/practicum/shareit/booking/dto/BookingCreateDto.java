package ru.practicum.shareit.booking.dto;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BookingCreateDto {
    @NotNull(message = "ID вещи не может быть пустым.")
    private Long itemId;

    @NotNull(message = "Дата начала бронирования не может быть пустой.")
    @Future(message = "Дата начала бронирования должна быть в будущем.")
    private LocalDateTime start;

    private LocalDateTime end;
}