package leetcode.iterations;

import java.util.ArrayList;
import java.util.Iterator;

//  https://leetcode.com/problems/container-with-most-water/
public class SimpleTwoPointer {

    public int maxArea(int[] height) {
        int maxArea = 0;
        int left = 0;
        int right = height.length - 1;

        while (left < right) {
            maxArea = Math.max(maxArea, (right - left) * Math.min(height[left], height[right]));
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
            System.out.println(left + " " + right);
            System.out.println(height[left] + " " + height[right]);

        }

        return maxArea;
    }
}

 class Main {
    public static void main(String[] args) {
        int[] heightSet = new int[]{1, 3, 5, 9, 8, 9, 7, 3, 4};

        SimpleTwoPointer simpleTwoPointer = new SimpleTwoPointer();
        System.out.println(simpleTwoPointer.maxArea(heightSet));
    }


}
