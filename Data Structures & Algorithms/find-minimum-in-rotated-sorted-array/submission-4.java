class Solution {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        if (nums[left] <= nums[right]) return nums[left];
        while (left <= right) {
            int mid = left + (right - left) / 2;

            // found if left is bigger than current
            if (mid > 0 && nums[mid] < nums[mid - 1]) {
                return nums[mid];
            }
            
             if (nums[left] <= nums[mid] && nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return nums[0];
    }
}
