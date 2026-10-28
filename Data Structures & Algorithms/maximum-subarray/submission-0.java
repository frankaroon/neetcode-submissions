class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int currSum = Integer.MIN_VALUE;
        for (int num : nums) {
            if (currSum < 0) {
                currSum = 0;
            }

            currSum += num;
            maxSum = Math.max(maxSum, currSum);
        }
        return maxSum;
    }
}

/*
brute force solution:
requires looping through every subarray and calculating a sum and of those we return the max

variables:
i and j 
currSum 
max

instead we loop through using two pointer approach

i - we increase this as long as curr sum is negative
j - increment as long as curr sum is positive

calculate currSum at each i and j and compare it amongst max
*/