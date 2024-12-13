package ru.practicum.shareit.item.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.practicum.shareit.user.model.User;

@Entity
@Table(name = "items")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Item {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;                // уникальный идентификатор вещи

    @Column(name = "name", nullable = false)
    private String name;            // краткое название

    @Column(name = "description", nullable = false)
    private String description;     // развёрнутое описание

    private Boolean available;      // статус о том, доступна или нет вещь для аренды

    @ManyToOne
    @JoinColumn(name = "owner_id", nullable = false)
    private User owner;             // владелец вещи
}