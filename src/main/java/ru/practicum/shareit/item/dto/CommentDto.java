package ru.practicum.shareit.item.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CommentDto {

    private Long id;
    private String text;
    private ItemDto item;
    private String authorName;
    private LocalDateTime created;

    public CommentDto(Long id, String text, ItemDto item, String authorName, LocalDateTime created) {
        this.id = id;
        this.text = text;
        this.item = item;
        this.authorName = authorName;
        this.created = created;
    }
}