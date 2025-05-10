import java.util.*;

class Solution {
    public TreeNode reverseOddLevels(TreeNode root) {
        if (root == null) return null;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int level = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<TreeNode> currentLevel = new ArrayList<>();

            // Store all nodes at the current level
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                currentLevel.add(node);
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }

            // If it's an odd level, reverse the values
            if (level % 2 == 1) {
                int left = 0, right = currentLevel.size() - 1;
                while (left < right) {
                    int temp = currentLevel.get(left).val;
                    currentLevel.get(left).val = currentLevel.get(right).val;
                    currentLevel.get(right).val = temp;
                    left++;
                    right--;
                }
            }

            level++;
        }

        return root;
    }
}
