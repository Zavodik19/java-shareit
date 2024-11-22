package ru.practicum.shareit.item.repository;

import org.springframework.stereotype.Repository;
import ru.practicum.shareit.exception.NotFoundException;
import ru.practicum.shareit.item.model.Item;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class ItemRepositoryImpl implements ItemRepository {
    private final Map<Long, Item> items = new HashMap<>(); // Добавлен private final к полю items
    private long currentId = 1;

    @Override
    public Item createItem(Item item) {
        item.setId(currentId++);
        items.put(item.getId(), item);
        return item;
    }

    @Override
    public Item updateItem(Item item) {
        if (!items.containsKey(item.getId())) {
            throw new NotFoundException("Вещь с таким ID не найдена");
        }
        items.put(item.getId(), item);
        return  item;
    }

    @Override
    public Item getItemById(Long itemId) {
        Item item = items.get(itemId);
        if (item == null) {
            throw new NotFoundException("Вещь с таким ID не найдена");
        }
        return item;
    }

    @Override
    public List<Item> getItemsByUserId(Long userId) {
        return items.values().stream()
                .filter(item -> item.getOwner().equals(userId))
                .collect(Collectors.toList());
    }

    @Override
    public List<Item> searchItemByText(String text) {
        if (text == null || text.trim().isEmpty()) {
            return List.of();
        }

        String lowerCaseText = text.toLowerCase();

        return items.values().stream()
                .filter(item -> item.getAvailable() != null && item.getAvailable() &&
                        (item.getName() != null && item.getName().toLowerCase().contains(lowerCaseText) ||
                                item.getDescription() != null && item.getDescription().toLowerCase().contains(lowerCaseText)))
                .collect(Collectors.toList());
    }
}
