package sobes;

public class MonotoneSeq {
    public static void main(String[] args) {
        int [] seq = {1,3,4, 5,7};
//        int [] seq = {5,4,2, 1};
//        int [] seq = {5,4,6, 1};
//        int [] seq = {};
        boolean res = true;
        boolean up = true;
        boolean down = true;

        for (int i=1; i< seq.length; i++ ) {
            up  = up && seq[i-1] < seq[i];
            down  = down && seq[i-1] > seq[i];
            if (!up && !down) {
                res = false;
                break;
            }
        }
        System.out.println(up || down  );
        System.out.println(res + " "   + up + " " +  down );
    }
}
