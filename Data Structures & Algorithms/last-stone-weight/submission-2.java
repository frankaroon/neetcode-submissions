class Solution {
    public int lastStoneWeight(int[] stones) {
        Queue<Integer> maxHeap = new PriorityQueue<>((a,b) -> Integer.compare(b, a));
        Arrays.stream(stones).forEach(maxHeap::add);
        while (maxHeap.size() > 1) {
        int firstStone = maxHeap.poll();
        int secondStone = maxHeap.poll();
        int remainingStone = Math.abs(firstStone - secondStone);
        maxHeap.add(remainingStone);
        }
        return !maxHeap.isEmpty() ? maxHeap.poll() : 0;
    }
}
