class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();
        for (int[] interval : intervals) {
            if (newInterval == null || interval[1] < newInterval[0]) {
                // new interval comes after interval[i]
                res.add(interval);
            } else if (interval[0] > newInterval[1]) {
                // new interval comes immediatly before
                res.add(newInterval);
                res.add(interval);
                newInterval = null;
            } else {
                // new interval requires a merge
                newInterval[0] = Math.min(interval[0], newInterval[0]);
                newInterval[1] = Math.max(interval[1], newInterval[1]);
            }
        }
        if (newInterval != null) res.add(newInterval);
        return res.toArray(new int[res.size()][]);
    } 
}

/*

*/