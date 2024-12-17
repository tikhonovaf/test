package common;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

public class HashCode {
    public static void main(String[] args) {
        Simple s1 = new Simple();
        System.out.println(" hashCode: "  +  s1.hashCode());
        s1.setName("uytuytuyt");
        System.out.println(" hashCode: "  +  s1.hashCode());
        s1.setName("Gena");
        System.out.println(" hashCode: "  +  s1.hashCode());
        System.out.println(s1.hashCode());
    }


}

@Setter
@Getter
//@EqualsAndHashCode
class Simple {
private String name;

}
