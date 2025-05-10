import java.util.Scanner;

class Solution {
    public int subtractProductAndSum(int n) {
        int sum = 0;
        int product = 1;

        while (n > 0) {
            int r = n % 10; 
            n = n / 10;
            sum = sum + r;
            product = product * r;
        }

        int diff = product - sum;
        return diff; 
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = sc.nextInt();
        
        Solution solution = new Solution();
        int result = solution.subtractProductAndSum(n);
        
        System.out.println("Difference between product and sum of the digits is: " + result);
        
        sc.close();
    }
}