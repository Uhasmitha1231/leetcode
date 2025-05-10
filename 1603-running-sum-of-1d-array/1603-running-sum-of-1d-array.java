class Solution {
    public int[] runningSum(int[] nums) {
       int runningSum = nums[0];
       for (int i = 1; i < nums.length; i++)  {
        runningSum += nums[i];
        nums[i] = runningSum;
       }
       return nums;
    }   
}