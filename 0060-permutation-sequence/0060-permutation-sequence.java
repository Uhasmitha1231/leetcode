import java.util.*;

class Solution {
    public String getPermutation(int n, int k) {
        List<Integer> numbers = new ArrayList<>();
        int fact = 1;

        // Create list of numbers and compute n!
        for (int i = 1; i <= n; i++) {
            numbers.add(i);
            fact *= i;
        }

        StringBuilder result = new StringBuilder();
        k--; // convert to 0-based index

        for (int i = 0; i < n; i++) {
            fact /= (n - i);
            int index = k / fact;
            result.append(numbers.get(index));
            numbers.remove(index);
            k %= fact;
        }

        return result.toString();
    }
}
