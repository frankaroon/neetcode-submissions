class Solution {
    public int[] topKFrequent(int[] nums, int k) {
          // frequency map (index, freq) add into heap
          // loop till k and add into array

          Map<Integer, Integer> freq = new HashMap<>(); 
          for (int i = 0; i < nums.length; i++) {
               if (!freq.containsKey(nums[i])) {
                    freq.put(nums[i], 0);
               }

               freq.put(nums[i], freq.get(nums[i]) + 1);
          }

          PriorityQueue<Map.Entry<Integer, Integer>> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b.getValue(), a.getValue()));
          for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
               maxHeap.add(entry);
          }

          int[] ans = new int[k];
          for (int i = 0; i < k; i++) {
               ans[i] = maxHeap.poll().getKey();
          }

          return ans;
    }
}
