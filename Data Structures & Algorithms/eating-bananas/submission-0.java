class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 0;
        int right = 0; 
        for (int pile : piles) {
            right = Math.max(right, pile); 
        }        

        int res = right;
        while (left <= right) {
            int k = (right + left) / 2;

            long time = 0;
            for (int pile : piles) {
                time += Math.ceil((double)pile / k);
            }

            if (time <= h) {
                res = k;
                right = k - 1;
            } else {
                left = k + 1;
            }
        }
        return res;
    }
}
