package services;

import model.Item;
import org.junit.jupiter.api.Test;
import repository.CardMemoryImpl;
import repository.CardRepository;

import static org.junit.jupiter.api.Assertions.*;

class CardServiceAddTest {
    private CardRepository cardRepository = CardMemoryImpl.getInstance();
    private CardServiceAdd cardServiceAdd = new CardServiceAdd(cardRepository);

    @Test
    public void whenAddItemInTheCardToNameIsShort(){
        Item item  = new Item("na","10€" );
        Boolean correctAdd =cardServiceAdd.addItem(item);
        assertEquals(correctAdd,false);
    }
    @Test
    public void whenAddItemInPriceIsNotContentEuro(){
        Item item  = new Item("namesItem", "100");
        Boolean correctAdd =cardServiceAdd.addItem(item);
        assertEquals(correctAdd,false);
    }
    @Test
    public void whenAddCorrectItem(){
        Item item  = new Item("namesItems", "100€");
        Boolean correctAdd =cardServiceAdd.addItem(item);
        assertEquals(correctAdd,true);
    }

}