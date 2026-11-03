class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> res = new ArrayList<>();
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        for (int[] interval : intervals) {
            minHeap.add(interval);
        }

        while (!minHeap.isEmpty()) {
            int[] a = minHeap.poll();
            int[] b = minHeap.poll();

            if (b == null) {
                res.add(a);
                break;
            } else if (a[1] >= b[0]) {
                a[1] = Math.max(a[1], b[1]);
                minHeap.add(a); 
            } else {
                res.add(a);
                minHeap.add(b);
            }
        }

        return res.toArray(new int[res.size()][]);
    }
}

/*
variables:
minHeap - keep track of the smallest start interval
res - result list

algorithm:
insert all intervals into minHeap
while minHeap is not empty
    a = pop from minHeap
    b = pop from minHeap
    if b = null
        include it in res and break
    else if a and b overlap
        merge them
        push them back into heap
    else if current interval do not overlap w prev interval
        include a in res
        push b back into minHeap
return res;

*/