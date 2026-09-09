class Solution {
    public int[] topKFrequent(int[] nums, int k) {
       HashMap<Integer, Integer> map = new HashMap<>();
       for (int num : nums) {
            if (!map.containsKey(num)) {
                map.put(num, 0);
            }
            map.put(num, map.get(num)+1);
       }

       PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> map.get(b) - map.get(a));
       for (int key : map.keySet()) {
            maxHeap.offer(key);
       }

       int[] ans = new int[k];
       for (int i = 0; i < k; i++) {
            ans[i] = maxHeap.poll();
       }
       return ans;       
    }
}
