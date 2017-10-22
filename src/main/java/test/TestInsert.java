package test;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import io.vavr.jackson.datatype.VavrModule;

import static com.fasterxml.jackson.databind.PropertyNamingStrategy.KEBAB_CASE;
import static io.vavr.API.List;

public class TestInsert {
  public static void main(String[] args) {
    ObjectMapper mapper = new ObjectMapper()
        .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
        .setPropertyNamingStrategy(KEBAB_CASE)
        .registerModule(new VavrModule());

    MongoClient mongoClient = new MongoClient("localhost", 27017);
    MongoDatabase mongoDatabase = mongoClient.getDatabase("shops");
    MongoCollection mongoCollection = mongoDatabase.getCollection("shops");
    mongoCollection.insertOne(new Shop("shopname", List()));
  }
}
