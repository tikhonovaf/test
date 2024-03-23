package testing;


public class Test_3 {
    public static void main(String[] args) {
        assertEquals("a", getFirstUniqueChar("apfvvq"));
        assertEquals("b", getFirstUniqueChar("abcdalk"));
        assertEquals("a", getFirstUniqueChar("bdbdccan"));
    }

    public static String getFirstUniqueChar(String inputStr) {

        return "";
    }

    public static void assertEquals(String expected, String result) {
        if (expected.equals(result)) {
            System.out.println("Успех");
        } else {
            throw new RuntimeException("Параметры не равны");
        }
    }
}
