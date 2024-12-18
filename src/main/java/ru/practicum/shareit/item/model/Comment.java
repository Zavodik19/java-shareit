package ru.practicum.shareit.item.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.practicum.shareit.user.model.User;

import java.time.LocalDateTime;

@Entity
@Table(name = "comments")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Comment {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;                    // Уникальный идентификатор отзыва

    @ManyToOne
    @JoinColumn(name = "item_id", nullable = false)
    private Item item;                  // Вещь, к которой относится отзыв

    @ManyToOne
    @JoinColumn(name = "author_id", nullable = false)
    private User author;                // Автор отзыва

    @Column(name = "text", nullable = false)
    private String text;                // Текст отзыва

    @Column(name = "created", nullable = false)
    private LocalDateTime created;      // Дата создания отзыва
}
