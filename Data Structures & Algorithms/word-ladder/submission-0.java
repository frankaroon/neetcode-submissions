class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // wildCard approach for finding neighbors
        int m = beginWord.length();
        Map<String, List<String>> map = new HashMap<>();
        for (String word : wordList) {
            for (int i = 0; i < m; i++) {
                String wildcard = word.substring(0, i) + "*" + word.substring(i + 1);
                if (!map.containsKey(wildcard)) {
                    map.put(wildcard, new ArrayList<>());
                }
                map.get(wildcard).add(word);
            }
        }

        // double ended BFS: need seperation between where the nodes are coming from
        Deque<String> qb = new ArrayDeque<>();
        Deque<String> qe = new ArrayDeque<>();
        qb.offer(beginWord);
        qe.offer(endWord);

        // tracking of the distances and visited nodes
        Map<String, Integer> fromBegin = new HashMap<>();
        Map<String, Integer> fromEnd = new HashMap<>();

        fromBegin.put(beginWord, 1);
        fromEnd.put(endWord, 1);

        while (!qb.isEmpty() && !qe.isEmpty()) {
            // poll from the smaller side Bidirectional BFS is about meeting in the middle 
            // expanding the smaller side gets you there fastest.
            if (qb.size() < qe.size()) {
                Deque<String> tmp = qb;
                qb = qe;
                qe = tmp;
                Map<String, Integer> tmpMap = fromBegin;
                fromBegin = fromEnd;
                fromEnd = tmpMap;
            }

            // bidirectional BFS, you are always expanding layer by layer. That invariant never changes.
            // this will guarantee the minimum shortest path
            int size = qb.size();
            while (size-- > 0) {
                String word = qb.poll();
                for (int i = 0; i < m; i++) {
                    String wildcard = word.substring(0, i) + "*" + word.substring(i+1);

                    if (map.containsKey(wildcard)) {
                        List<String> neighbors = map.get(wildcard);
                        for (String neighbor : neighbors) {
                            int steps = fromBegin.get(word);
                            // in the case the fromEnd map meets up with fromBegin map then we found the total distance
                            if (fromEnd.containsKey(neighbor)) {
                                return steps + fromEnd.get(neighbor);
                            }

                            if (!fromBegin.containsKey(neighbor)) {
                                fromBegin.put(neighbor, steps + 1);
                                qb.offer(neighbor);
                            }
                        }
                    }
                }
            }
        }

        return 0;
    }
}
