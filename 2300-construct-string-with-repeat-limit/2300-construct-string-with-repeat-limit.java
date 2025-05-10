import java.util.*;

class Solution {
    public String repeatLimitedString(String s, int repeatLimit) {
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0) pq.offer(i);
        }

        StringBuilder sb = new StringBuilder();

        while (!pq.isEmpty()) {
            int curr = pq.poll();
            int count = Math.min(freq[curr], repeatLimit);

            // Append the current character up to repeatLimit times
            for (int i = 0; i < count; i++) {
                sb.append((char)(curr + 'a'));
            }
            freq[curr] -= count;

            if (freq[curr] > 0) {
                // Try to insert a different character between the same chars
                if (pq.isEmpty()) break; // Can't separate, done

                int next = pq.poll();
                sb.append((char)(next + 'a'));
                freq[next]--;
                if (freq[next] > 0) pq.offer(next);

                // Re-add current back to the queue
                pq.offer(curr);
            }
        }

        return sb.toString();
    }
}
