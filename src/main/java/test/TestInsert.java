package test;

import java.io.IOException;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import io.vavr.jackson.datatype.VavrModule;
import org.bson.Document;

import static com.fasterxml.jackson.databind.PropertyNamingStrategy.KEBAB_CASE;
import static io.vavr.API.List;

public class TestInsert {
  public static void main(String[] args) throws IOException {
    ObjectMapper mapper = new ObjectMapper()
        .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
        .setPropertyNamingStrategy(KEBAB_CASE)
        .registerModule(new VavrModule());

    Shop shop = new Shop("shopname", List());
    String jsonShop = mapper.writeValueAsString(shop);
    System.out.println(jsonShop);
    System.out.println(mapper.readValue(jsonShop, Shop.class));

    MongoClient mongoClient = new MongoClient("localhost", 27017);
    MongoDatabase mongoDatabase = mongoClient.getDatabase("shops");
    MongoCollection<Document> mongoCollection = mongoDatabase.getCollection("shops");
    mongoCollection.insertOne(Document.parse(jsonShop));
  }
}
