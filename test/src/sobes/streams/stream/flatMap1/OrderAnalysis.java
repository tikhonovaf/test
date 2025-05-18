package sobes.streams.stream.flatMap1;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class OrderAnalysis {
    // ���������� ������ ��������� ������
    public static Double calculateOrderTotal(Order order) {
        return order.getProducts().stream()
                .map(p -> p.getPrice() * p.getQuantity())
//                .reduce(0.0, (sum, el) ->  sum + el);
                .reduce(Double::sum)
                .orElse(0.0);
    }

    // �������� ������ ������������ ������� �� �������
    public Set<String> getUniqueProductNames(List<Order> orders) {
        return  orders.stream()
                .flatMap(o -> o.getProducts().stream())
                .sorted(Comparator.comparing( p -> p.getName(), Comparator.reverseOrder()))
                .map(p -> p.getName())
                .collect(Collectors.toSet());
    }

   //  �������� ������������ N ���������� ���������
   public List<String> findMostPopularProducts(List<Order> orders, int topN) {
       var s =  orders.stream()
               .flatMap(o -> o.getProducts().stream())
               .collect(Collectors.groupingBy(Product::getName, Collectors.summingInt(Product::getQuantity)))
               .entrySet().stream()
               .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
//               .sorted(Comparator.comparing( s -> getComplexNum(s) ))
               .limit(topN)
               .map(m -> m.getKey())
               .collect(Collectors.toList());

       return s;
   }

}
