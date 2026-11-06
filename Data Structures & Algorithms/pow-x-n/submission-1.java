class Solution {
    public double myPow(double x, int n) {
        if (x == 0) {
            return 0;
        }

        if (n == 0) {
            return 1;
        }

        double res = 1;
        long power = Math.abs((long)n);
        while (power > 0) {
            if (power % 2 == 1) {
                res *= x;
            }

            x *= x;
            power = power / 2;
        }
        
        return n > 0 ? res : 1 / res;
    }
}

/*
myPow - binary exponentation

base case

1 - return x
0 - return 1

recursive case
keep dividing and multiple x 
*/ 