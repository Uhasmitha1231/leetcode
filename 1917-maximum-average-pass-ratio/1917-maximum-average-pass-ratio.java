import java.util.*;

class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<double[]> maxHeap = new PriorityQueue<>((a, b) -> 
            Double.compare(b[0], a[0])  // max heap based on gain
        );

        // Precompute and store gain of adding a student to each class
        for (int[] c : classes) {
            int pass = c[0], total = c[1];
            double gain = gain(pass, total);
            maxHeap.offer(new double[]{gain, pass, total});
        }

        // Assign extra students to classes that gain the most
        while (extraStudents-- > 0) {
            double[] top = maxHeap.poll();
            int pass = (int) top[1], total = (int) top[2];
            pass++;
            total++;
            double gain = gain(pass, total);
            maxHeap.offer(new double[]{gain, pass, total});
        }

        // Calculate final average
        double sum = 0.0;
        while (!maxHeap.isEmpty()) {
            double[] entry = maxHeap.poll();
            int pass = (int) entry[1], total = (int) entry[2];
            sum += (double) pass / total;
        }

        return sum / classes.length;
    }

    // Gain of adding one more student to the class
    private double gain(int pass, int total) {
        double before = (double) pass / total;
        double after = (double) (pass + 1) / (total + 1);
        return after - before;
    }
}
