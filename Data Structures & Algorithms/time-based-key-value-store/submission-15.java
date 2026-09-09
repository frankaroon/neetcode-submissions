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
        if (!map.containsKey(key)) return "";
        return binarySearch(key, timestamp);
    }

    private String binarySearch(String key, int timestamp) {
        List<Pair> store = map.get(key);
        if (store.size() == 0 || store.get(0).timestamp > timestamp) {
            return "";
        }

        int left = 0;
        int right = store.size() - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (timestamp == store.get(mid).timestamp) {
                return store.get(mid).value;
            }

            if (timestamp > store.get(mid).timestamp) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return store.get(right).value;
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
