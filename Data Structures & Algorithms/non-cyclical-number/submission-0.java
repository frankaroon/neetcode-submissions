class Solution {
    public boolean isHappy(int n) {
        Set<Integer> seen = new HashSet<>();
        while (n != 1) {
            if (seen.contains(n)) {
                return false;
            }
 
            seen.add(n);
            n = findSum(n);
        }
        return true;
    }

    public int findSum(int num) {
        if (num == 0) return num;
        int digit = num % 10;
        return digit*digit + findSum(num/10);
    }
}
