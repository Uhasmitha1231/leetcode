class Solution {
    public int minimumSize(int[] nums, int maxOperations) {
        int left = 1, right = getMax(nums);

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (canDivide(nums, maxOperations, mid)) {
                right = mid; // try a smaller max ball size
            } else {
                left = mid + 1; // increase the max ball size
            }
        }

        return left;
    }

    // Helper: Check if all bags can be split to maxSize with given operations
    private boolean canDivide(int[] nums, int maxOperations, int maxSize) {
        int operations = 0;

        for (int num : nums) {
            // Each split reduces a bag size to at most maxSize
            operations += (num - 1) / maxSize;
        }

        return operations <= maxOperations;
    }

    // Helper: Find the max element in the array
    private int getMax(int[] nums) {
        int max = 0;
        for (int num : nums) {
            max = Math.max(max, num);
        }
        return max;
    }
}
