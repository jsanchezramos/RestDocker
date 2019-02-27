package resources;

import model.Item;
import repository.CardMemoryImpl;
import repository.CardRepository;
import services.CardServiceAdd;
import services.CardServiceGetItems;

import javax.inject.Singleton;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("card")
public final class CardResourcePost {
    @Singleton
    private CardRepository cardRepository = CardMemoryImpl.getInstance();
    private CardServiceAdd cardServiceAdd =  new CardServiceAdd(cardRepository);

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addItem(Item item){
        if(cardServiceAdd.addItem(item)){
            String result = "{ \"result\" : \"Item saved\" }";
            return Response.status(201).entity(result).build();
        }else{
            String result = "{ \"result\" : \"Item error save\" }";
            return Response.status(400).entity(result).build();
        }
    }
}
