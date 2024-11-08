package leetcode.iterations;

import java.util.ArrayList;
import java.util.List;

//  https://leetcode.com/problems/partition-labels/solutions/4752874/java-greedy-two-pointers/
public class SimpleTwoPointer_2 {

    public List<Integer> partitionLabels(String s) {

        int len  = s.length();
        int max = 0;
        int prev = 0;

        List<Integer> ans = new ArrayList<>();

        for(int i = 0 ; i < len ; i++){
            char ch = s.charAt(i);
            int lastIdx = s.lastIndexOf(ch);
            if(max < lastIdx)
                max = lastIdx;
            if(max == i){
                if(ans.size() == 0)
                    ans.add(max + 1); // for 0 - max extra one number is there
                else
                    ans.add(max  - prev);
                prev = max;
                max = 0;
            }
        }
        return ans;
    }
}

 class Main_2 {
    public static void main(String[] args) {
        SimpleTwoPointer_2 simpleTwoPointer_2 = new SimpleTwoPointer_2();
        List <Integer> res = simpleTwoPointer_2.partitionLabels("eccbbbbdec") ;
        System.out.println(res);

    }


}
