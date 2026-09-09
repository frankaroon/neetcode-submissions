class Solution {
    public int lastStoneWeight(int[] stones) {
        // max heap
        Queue<Integer> maxHeap = new PriorityQueue<>((a,b) -> Integer.compare(b, a));
        Arrays.stream(stones).forEach(maxHeap::add);
        // loop ----
        while (maxHeap.size() > 1) {
        // grab two largest stones
        int firstStone = maxHeap.poll();
        int secondStone = maxHeap.poll();
        // destroy the stones
        int remainingStone = Math.abs(firstStone - secondStone);
        // reinclude stone into the simulation
        maxHeap.add(remainingStone);
        }
        // return anything remaining on the heap if none 0
        return !maxHeap.isEmpty() ? maxHeap.poll() : 0;
    }
}
