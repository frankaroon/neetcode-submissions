class Solution {
    public boolean isHappy(int n) {
        if (n == 1) return true;

        int slow = n;
        int fast = findSum(n);
        while (slow != 1 && fast != 1 && slow != fast) {
            slow = findSum(slow);
            fast = findSum(findSum(fast));
        }

        return slow != fast;
    }

    public int findSum(int num) {
        int res = 0;
        while (num != 0) {
            res += (num % 10) * (num % 10);
            num /= 10;
        }
        return res;
    }
}

