package sobes.streams.stream.flatMap1;

import lombok.Data;

import java.util.List;

@Data
public class Order {
   String orderId;
   String customerName;
   List<Product> products;

}
