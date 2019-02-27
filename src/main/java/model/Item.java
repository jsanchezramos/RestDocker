package model;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public final class Item {
    private String nameItem;
    private String priceItem;

    public Item(@NotNull String nameItem,@NotNull String priceItem) {

        this.nameItem = nameItem;
        this.priceItem = priceItem;
    }

    public Item() {
    }

    public String getNameItem() {
        return nameItem;
    }

    public String getPriceItem() {
        return priceItem;
    }
}
