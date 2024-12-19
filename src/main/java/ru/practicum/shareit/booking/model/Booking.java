package ru.practicum.shareit.booking.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.practicum.shareit.item.model.Item;
import ru.practicum.shareit.user.model.User;

import java.time.LocalDateTime;

@Entity
@Table(name = "bookings")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Booking {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;                    // уникальный идентификатор бронирования

    @Column(name = "start_date", nullable = false)
    private LocalDateTime start;        // дата и время начала бронирования

    @Column(name = "end_date", nullable = false)
    private LocalDateTime end;          // дата и время конца бронирования

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id", nullable = false)
    private Item item;                  // вещь, которую пользователь бронирует

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "booker_id", nullable = false)
    private User booker;                // пользователь, который осуществляет бронирование

    @Enumerated(EnumType.STRING)
    private BookingStatus status;       // Статус бронирования.
}