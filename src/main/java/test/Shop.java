package test;

import io.vavr.collection.List;
import lombok.Value;

@Value
public class Shop {
  private final String name;
  private final List<String> products;
}
