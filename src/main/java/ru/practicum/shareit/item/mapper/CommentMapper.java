package ru.practicum.shareit.item.mapper;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import ru.practicum.shareit.item.dto.CommentDto;
import ru.practicum.shareit.item.model.Comment;
import ru.practicum.shareit.item.model.Item;
import ru.practicum.shareit.user.model.User;

import java.time.LocalDateTime;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CommentMapper {

    public CommentDto toCommentDto(Comment comment) {
        return new CommentDto(
                comment.getId(),
                comment.getText(),
                null,
                comment.getAuthor().getName(),
                comment.getCreated()
        );
    }

    public Comment toComment(CommentDto commentDto, Item item, User author) {
        return new Comment(
                null,
                item,
                author,
                commentDto.getText(),
                LocalDateTime.now()
        );
    }
}
