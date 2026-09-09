class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> seqs = new HashSet<>();
        for (int num : nums) {
            seqs.add(num);
        }

        int max = 0;
        for (int num : nums) {
            // start of the set
            if (!seqs.contains(num-1)) {
                int l = 0;
                while (seqs.contains(num++)) {
                    l++;
                }
                max = Math.max(max, l);
            }
        }
        return max;
    }
}
