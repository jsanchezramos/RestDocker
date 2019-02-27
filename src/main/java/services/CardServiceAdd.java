package services;

import model.Item;
import repository.CardRepository;

import javax.validation.constraints.NotNull;

public final class CardServiceAdd {
    private CardRepository cardRepository;

    public CardServiceAdd(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    public Boolean addItem(@NotNull Item item){
        Boolean isOk = true;
        if(checkItem(item)){
            cardRepository.addItem(item);
        }else
            isOk = false;
        return isOk;
    }
    private Boolean checkItem(Item item){
        return item.getPriceItem().length() > 1 && item.getPriceItem().contains("€") && item.getNameItem().length() > 4;
    }
}
