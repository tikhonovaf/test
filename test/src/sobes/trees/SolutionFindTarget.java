package sobes.trees;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class SolutionFindTarget {
    boolean findTarget(TreeNode root, int target) {
//        HashSet<Integer> set = new HashSet<>();
        List<Integer> li = new ArrayList<>();
        return find(root, target, li);
//        return find(root, target, set);
    }

//    private boolean find(TreeNode root, int target, HashSet<Integer> set) {
        private boolean find(TreeNode root, int target, List<Integer>  li) {
        if (root == null) {
            return false;
        }
//        if (set.contains(target - root.val)) {
//            return true;
//        }
//        set.add(root.val);
//        return find(root.left, target, set) || find(root.right, target, set);
            if (li.contains(target - root.val)) {
                return true;
            }
            li.add(root.val);
            return find(root.left, target, li) || find(root.right, target, li);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(7);

        SolutionFindTarget solution = new SolutionFindTarget();
        int target = 9;
        System.out.println(solution.findTarget(root, target)); // Output: true
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
