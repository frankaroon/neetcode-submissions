class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        int prevEnd = intervals[0][1];
        int removed = 0;
        for (int i = 1; i < intervals.length; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];
            if (prevEnd > start) {
                removed++;
                prevEnd = Math.min(end, prevEnd);
            } else {
                prevEnd = end;
            }
        }
        return removed;
    }
}

/*
sort by start
we can choose the greedy algorithm here
remove the one that ends the soonest

loop starting at i = 1
    if interval[i-1] and interval[i] intersect
        mark the end that is the smallest
        increment removed
*/