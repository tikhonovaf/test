package temp.stream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamTest5 {
    public static void main(String[] args) {
        String s1 = "gggghjghjl;k;k";
        var s11 = s1.toCharArray();
        Arrays.sort(s11);


//        var s1Mods = Arrays.stream(s1.split(""))
//                .distinct()
//                .sorted()
//                .collect( Collectors.joining( "" ) );
        String s2 = "gggghjghjl;k;k";

    }
}
