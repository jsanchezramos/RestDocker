package repository;

import model.Item;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CardRepositoryTest {
    private CardRepository cardRepository = CardMemoryImpl.getInstance();

    @Test
    public void whenAddItemInTheCard(){
        Item item = new Item("Bota", "10€");
        cardRepository.addItem(item);
        assertEquals(cardRepository.getItems().size(), 1);
    }
    @Test
    public void whenAddItemNullInTheCard(){
        cardRepository.addItem(null);
        assertEquals(cardRepository.getItems().size(), 0);
    }

}