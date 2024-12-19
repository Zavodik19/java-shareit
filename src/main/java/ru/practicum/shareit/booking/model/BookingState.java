package ru.practicum.shareit.booking.model;

public enum BookingState {
    ALL,        // Все бронирования
    CURRENT,    // Текущие бронирования
    PAST,       // Завершенные бронирования
    FUTURE,     // Будущие бронирования
    WAITING,    // Ожидающие подтверждения
    REJECTED    // Отклоненные бронирования
}