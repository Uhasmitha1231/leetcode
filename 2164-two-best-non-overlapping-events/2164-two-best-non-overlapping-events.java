import java.util.*;

class Solution {
    public int maxTwoEvents(int[][] events) {
        // Sort events by start time for binary search
        Arrays.sort(events, (a, b) -> a[0] - b[0]);
        int n = events.length;

        // Preprocess: max value from index i to end
        int[] maxFrom = new int[n];
        maxFrom[n - 1] = events[n - 1][2];
        for (int i = n - 2; i >= 0; i--) {
            maxFrom[i] = Math.max(events[i][2], maxFrom[i + 1]);
        }

        int maxTotal = 0;

        for (int i = 0; i < n; i++) {
            int currEnd = events[i][1];
            int currValue = events[i][2];

            // Binary search: find the first event that starts after currEnd
            int left = i + 1, right = n - 1, idx = n;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (events[mid][0] > currEnd) {
                    idx = mid;
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }

            // Combine current event with best non-overlapping event
            int total = currValue + (idx < n ? maxFrom[idx] : 0);
            maxTotal = Math.max(maxTotal, total);
        }

        return maxTotal;
    }
}
