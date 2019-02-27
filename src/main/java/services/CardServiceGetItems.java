package services;

import model.Item;
import repository.CardRepository;

import java.util.List;

public final class CardServiceGetItems {
    private CardRepository cardRepository;

    public CardServiceGetItems(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    public List<Item> getItems(){
        return cardRepository.getItems();
    }
}
