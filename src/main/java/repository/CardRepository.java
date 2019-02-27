package repository;

import model.Item;
import java.util.List;

public interface CardRepository {
    void addItem(Item item);
    List<Item> getItems();
}
