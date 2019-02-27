package services;

import model.Item;
import org.junit.jupiter.api.Test;
import repository.CardMemoryImpl;
import repository.CardRepository;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CardServiceGetItemsTest {

    private CardRepository cardRepository = CardMemoryImpl.getInstance();
    private CardServiceGetItems cardServiceGetItems = new CardServiceGetItems(cardRepository);

    @Test
    public void whenGetListAllItemsIsEmpty(){
        List<Item> lItems = cardServiceGetItems.getItems();
        assertEquals(lItems.size(),0);
    }
    @Test
    void whenGetListAllItemsBeforeAddItem(){
        CardServiceAdd cardServiceAdd = new CardServiceAdd(cardRepository);

        Item item = new Item("nameItem", "price item");
        cardServiceAdd.addItem(item);
        List<Item> lItem = cardServiceGetItems.getItems();
        assertEquals(lItem.size(),1);
    }
}