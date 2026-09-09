class Solution {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        
        while (left <= right) {
            int mid = (left + right) / 2;

            // found target
            if (nums[mid] == target) return mid;

            // binary search conditions:
            if (nums[left] <= nums[mid]) {
                if (nums[left] > target ||  target > nums[mid])
                    // go to right search space 
                    left = mid + 1;
                else 
                    // go to left search space 
                    right = mid - 1;
            } else {
                if (nums[mid] > target || target > nums[right])
                    // go to the right search space
                    right = mid - 1; 
                else
                    // go to left search space
                    left = mid + 1;
            }
        }

        return -1;
    }
}
