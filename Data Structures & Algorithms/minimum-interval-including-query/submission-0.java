class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        /*
        variables:
            Map<int, int> originalIndices- stores original ranges
            minheap<int[range][end]> - nonoverlapping intervals
            int[] result - answer

        psuedo:
            sort using a intervals using a minheap (range, end)
            sort queries and perserve index for results with map
            loop through queries
                loop through intervals until its out of range for query
                    add to minHeap
                loop through minHeap 
                    pop all that old intervals that are out of range 
                add the top to results
            return results 
            
        */
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        Map<Integer, Integer> res = new HashMap<>();
        int i = 0;
        for (int q : Arrays.stream(queries).sorted().toArray()) {
            // add all intervals in range  to the heap
            while (i < intervals.length && intervals[i][0] <= q) {
                int l = intervals[i][0];
                int r = intervals[i][1];
                minHeap.offer(new int[]{r - l + 1, r});
                i++;
            }
            // poll any old intervals from the heap 
            while (!minHeap.isEmpty() && minHeap.peek()[1] < q) {
                minHeap.poll();
            }
            // add the top of the heap to results
            res.put(q, minHeap.isEmpty() ? -1 : minHeap.peek()[0]);
        }
        
        int[] result = new int[queries.length];
        for (int j = 0; j < queries.length; j++) {
            result[j] = res.get(queries[j]);
        }
        return result;
    }
}
