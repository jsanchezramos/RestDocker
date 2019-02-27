package resources;

import model.Item;
import repository.CardMemoryImpl;
import repository.CardRepository;
import services.CardServiceGetItems;

import javax.inject.Singleton;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("card")
public final class CardResourceGet {
    @Singleton
    private CardRepository cardRepository = CardMemoryImpl.getInstance();
    private CardServiceGetItems cardServiceGetItems = new CardServiceGetItems(cardRepository);

    @GET
    public Response listItems(){
        List<Item> lItems = cardServiceGetItems.getItems();
        if(lItems.size()>0){
            return Response.ok(lItems, MediaType.APPLICATION_JSON).build();
        }else{
            return Response.ok("{ \"result\" : \"No items in card\" }", MediaType.APPLICATION_JSON).build();
        }
    }
}
