class Solution {
    public boolean canJump(int[] nums) {
        int maxJump = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            maxJump = Math.max(--maxJump, nums[i]);
            if (maxJump <= 0) {
                return false;
            }
        }
        return true;
    }
}

/*
can I reach i by checking each earlier index j

keep a running count of the furthest you can jump

steps

0) initialize int furthest
1) loop through the nums
2) decrement furthest
3) if the num is greater than furthest replace
4) if reach a point where furthest is 0 and your not at the end return false
5) exit loop and return true;
*/