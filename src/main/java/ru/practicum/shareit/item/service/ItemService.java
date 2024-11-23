package ru.practicum.shareit.item.service;

import ru.practicum.shareit.item.dto.ItemDto;

import java.util.List;

public interface ItemService {
    ItemDto createItem(Long userId, ItemDto itemDto);

    ItemDto updateItem(Long userId, Long itemId, ItemDto itemDto);

    ItemDto getItemById(Long itemId, Long userId);

    List<ItemDto> getItemsByUserId(Long userId);

    List<ItemDto> searchItemByText(String text);
}
