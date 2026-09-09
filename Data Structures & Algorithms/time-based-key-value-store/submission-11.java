class TimeMap {
    HashMap<String, ArrayList<Pair>> map;

    public TimeMap() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) { 
        if (!map.containsKey(key)) {
            map.put(key, new ArrayList<Pair>());
        }

        map.get(key).add(new Pair(value, timestamp));
    }

    // brute force: linear scan
    // optimized to be binary search log(n)
    public String get(String key, int timestamp) {

        if (!map.containsKey(key) || map.get(key).size() == 0) return "";

        ArrayList<Pair> pairs = map.get(key);
        int left = 0, right = pairs.size() - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int currTime = pairs.get(mid).timestamp;

            if (currTime == timestamp) return pairs.get(mid).str;

            // search right search space
            else if (timestamp < currTime) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(left + " left : right " + right);

        return left < 1 ?  "" : pairs.get(left - 1).str;
    }
}

class Pair {
    String str;
    int timestamp;
    
    // pair will consist of (string, int)
    public Pair(String str, int timestamp) {
        this.str = str;
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "Pair [str=" + this.str + ", timestamp=" + this.timestamp + "]";
    }
}