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
        System.out.println(map.toString());
    }

    // brute force: linear scan
    // optimized to be binary search log(n)
    public String get(String key, int timestamp) {
        ArrayList<Pair> pairs = map.get(key);

        if (!map.containsKey(key) || pairs.size() == 0) return "";

        int i;
        for (i = 0; i < pairs.size(); i++) {
            if (pairs.get(i).timestamp == timestamp) return pairs.get(i).str;
            else if (pairs.get(i).timestamp > timestamp) break;
        }

        return i < 1 ? "" : pairs.get(i - 1).str;
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