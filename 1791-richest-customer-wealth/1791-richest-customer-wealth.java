class Solution {
    public int maximumWealth(int[][] accounts) {
        int MaxWealth = 0;
        for (int row = 0; row < accounts.length; row++) {
            int CustomerWealth = 0;
             for (int col = 0; col < accounts[row].length; col++)  {
            CustomerWealth += accounts[row][col];
         }
          MaxWealth = Math.max(MaxWealth, CustomerWealth);
        }
        return MaxWealth;
    }
}