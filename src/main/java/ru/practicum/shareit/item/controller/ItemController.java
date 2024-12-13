package ru.practicum.shareit.item.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import ru.practicum.shareit.item.dto.CommentDto;
import ru.practicum.shareit.item.dto.ItemDto;
import ru.practicum.shareit.item.dto.ItemDtoOut;
import ru.practicum.shareit.item.service.ItemService;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/items")
@RequiredArgsConstructor
public class ItemController {
    private final ItemService itemService;
    private final String headerUserId = "X-Sharer-User-Id";

    @PostMapping
    public ItemDto createItem(@RequestHeader(headerUserId) Long userId, @RequestBody ItemDto itemDto) {
        log.info("Запрос на добавление вещи для пользователя {}: {}", userId, itemDto);
        return itemService.createItem(userId, itemDto);
    }

    @PatchMapping("/{itemId}")
    public ItemDto updateItem(@RequestHeader(headerUserId) Long userId, @PathVariable Long itemId,
                              @RequestBody ItemDto itemDto) {
        log.info("Запрос на обновление вещи для пользователя {}: {}", userId, itemDto);
        return itemService.updateItem(userId, itemId, itemDto);
    }

    @GetMapping("/{itemId}")
    public ItemDtoOut getItemById(@PathVariable Long itemId, @RequestHeader(headerUserId) Long userId) {
        log.info("Запрос на получение вещи по ID: {} для пользователя {}", itemId, userId);
        return itemService.getItemById(itemId, userId);
    }

    @GetMapping
    public List<ItemDto> getItemsByUserId(@RequestHeader(headerUserId) Long userId) {
        log.info("Запрос на получение вещей пользователя с ID: {}", userId);
        return itemService.getItemsByUserId(userId);
    }

    @GetMapping("/search")
    public List<ItemDto> searchItemByText(@RequestParam String text) {
        log.info("Запрос на получение вещей по поиску: {}", text);
        return itemService.searchItemByText(text);
    }

    @PostMapping("/{itemId}/comment")
    public CommentDto addComment(@RequestHeader(headerUserId) Long userId, @PathVariable Long itemId,
                                 @RequestBody CommentDto commentDto) {
        log.info("Запрос на добавление комментария от пользователя {} для вещи {}: {}", userId, itemId, commentDto);
        return itemService.addComment(userId, itemId, commentDto);
    }
}
