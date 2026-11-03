class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> output = new ArrayList<>();
        output.add(intervals[0]);
        for (int[] interval : intervals) {
            int start = interval[0];
            int end = interval[1];
            int lastEnd = output.get(output.size()-1)[1];

            if (start <= lastEnd) {
                output.get(output.size()-1)[1] = Math.max(end, lastEnd);
            } else {
                output.add(new int[]{start, end});
            }
        }
        return output.toArray(new int[output.size()][]);
    }
}

/*
variables:
output - result list

algorithm:
sort intervals
add first interval into output arr
loop through intervals
    grab the previous end in output
    if the start of new interval is < lastEnd
        merge
    otherwise
        append the interval to output
return output in array format
*/