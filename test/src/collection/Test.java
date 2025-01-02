package collection;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        User user = new User();
    }

    static class User {
        long id;
        User referal = new User();

        public void setReferalld(long referalld) {
            this.referal.id = referalld;
        }
    }

}