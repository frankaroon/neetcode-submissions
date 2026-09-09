class TimeMap {
    HashMap<String, ArrayList<Pair>> map; // Pair = (value, timestamp)

    public TimeMap() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) { 
        if (!map.containsKey(key)) {
            map.put(key, new ArrayList<>());
        }

        map.get(key).add(new Pair(value, timestamp));
    }

    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) {
            return "";
        }

        ArrayList<Pair> pairs = map.get(key);
        if (pairs.get(0).timestamp > timestamp) {
            return "";
        }
        
        for (int i = 1; i < pairs.size(); i++) {
            // value == timestamp
            if (pairs.get(i).timestamp == timestamp) {
                return pairs.get(i).value;
            }
            // value > timestamp 
            if (pairs.get(i).timestamp > timestamp) {
                return pairs.get(i-1).value;
            }
        }

        return pairs.get(pairs.size()-1).value;
    }
}

class Pair {
    String value;
    int timestamp;

    public Pair(String value, int timestamp) {
        this.value = value;
        this.timestamp = timestamp;
    }
}
