package test;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import static io.vavr.API.List;

public class TestRead {
  public static void main(String[] args) {
    MongoClient mongoClient = new MongoClient("localhost", 27017);
    MongoDatabase mongoDatabase = mongoClient.getDatabase("shops");
    MongoCollection mongoCollection = mongoDatabase.getCollection("shops");
    List().appendAll(mongoCollection.find())
        .forEach(System.out::println);

  }
}
