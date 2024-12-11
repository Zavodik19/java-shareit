package ru.practicum.shareit.booking.service;

import ru.practicum.shareit.booking.dto.BookingCreateDto;
import ru.practicum.shareit.booking.dto.BookingDto;
import ru.practicum.shareit.booking.model.BookingState;

import java.util.List;

public interface BookingService {
    BookingDto createBooking(Long userId, BookingCreateDto bookingCreateDto);
    // Добавление нового запроса на бронирование

    BookingDto approveBooking(Long ownerId, Long bookingId, Boolean approved);
    // Подтверждение или отклонение запроса

    BookingDto getBookingById(Long userId, Long bookingId);
    // Получение данных о конкретном бронировании

    List<BookingDto> getUserBookings(Long userId, BookingState state);
    // Получение списка всех бронирований текущего пользователя

    List<BookingDto> getOwnerBookings(Long ownerId, BookingState state);
    // Получение списка бронирований для всех вещей текущего пользователя
}