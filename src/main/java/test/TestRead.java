package test;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import io.vavr.collection.List;
import org.bson.Document;

import static com.mongodb.client.model.Filters.eq;
import static io.vavr.API.List;

public class TestRead {
  public static void main(String[] args) {
    MongoClient mongoClient = new MongoClient("localhost", 27017);
    MongoDatabase mongoDatabase = mongoClient.getDatabase("shops");
    MongoCollection<Document> mongoCollection = mongoDatabase.getCollection("shops", Document.class);
    List().appendAll(mongoCollection.find())
        .forEach(System.out::println);

    List().appendAll(mongoCollection.find(Document.parse("{\"name\": \"shopname\"}")))
        .forEach(System.out::println);

    List.ofAll(mongoCollection.find(eq("name", "shopname")))
        .forEach(System.out::println);
  }
}
