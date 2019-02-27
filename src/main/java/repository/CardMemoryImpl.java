package repository;

import model.Item;

import java.util.ArrayList;
import java.util.List;

/**
 * Singleton class to persistence information.
 */
public final class CardMemoryImpl implements CardRepository {
    private static CardMemoryImpl instance;
    public static synchronized CardMemoryImpl getInstance(){
        if(instance == null){
            instance = new CardMemoryImpl();
        }
        return instance;
    }
    private CardMemoryImpl(){
    }

    private List<Item> lItem = new ArrayList<>();

    @Override
    public void addItem(Item item) {
        if(item != null)lItem.add(item);
    }

    @Override
    public List<Item> getItems() {
        return lItem;
    }
}
