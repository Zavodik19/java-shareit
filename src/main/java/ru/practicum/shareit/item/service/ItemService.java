package ru.practicum.shareit.item.service;

import ru.practicum.shareit.item.dto.CommentDto;
import ru.practicum.shareit.item.dto.ItemDto;
import ru.practicum.shareit.item.dto.ItemDtoOut;

import java.util.List;

public interface ItemService {
    ItemDto createItem(Long userId, ItemDto itemDto);

    ItemDto updateItem(Long userId, Long itemId, ItemDto itemDto);

    ItemDtoOut getItemById(Long itemId, Long userId);

    List<ItemDto> getItemsByUserId(Long userId);

    List<ItemDto> searchItemByText(String text);

    CommentDto addComment(Long userId, Long id, CommentDto comment);
}
