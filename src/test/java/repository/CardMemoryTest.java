package repository;

import model.Item;

import java.util.ArrayList;
import java.util.List;

public final class CardMemoryTest implements CardRepository {
    private List<Item> lItem = new ArrayList<>();

    @Override
    public void addItem(Item item) {
        if (item != null) lItem.add(item);
    }

    @Override
    public List<Item> getItems() {
        return lItem;
    }
}
