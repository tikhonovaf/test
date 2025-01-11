package sobes.trees;

import java.util.List;

public class TreeDepth {
    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }
        if (root.children == null || root.children.isEmpty()) {
            return 1;
        }
        int maxDepth = 0;
        for (var child : root.children) {
            maxDepth = Math.max(maxDepth, maxDepth(child));
        }
        return maxDepth + 1;
    }

    public static void main(String[] args) {
        // Пример использования:
        Node root = new Node(1, List.of(
                new Node(2, List.of(
                        new Node(5),
                        new Node(6)
                )),
                new Node(3),
                new Node(4, List.of(
                        new Node(7, List.of(
                                new Node(8)
                        ))
                ))
        ));

        TreeDepth solution = new TreeDepth();
        System.out.println(solution.maxDepth(root));  // Вывод: 4
    }
}

