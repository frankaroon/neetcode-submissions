class Solution {
    static final String SOURCE = "JFK";
    List<String> itinerary = new ArrayList<>();
    Map<String, List<String>> graph = new HashMap<>();

    public List<String> findItinerary(List<List<String>> tickets) {
        // creating graph and sorting to ensure its lexicographical
        for (List<String> ticket : tickets) {
            String from = ticket.get(0);
            String to = ticket.get(1);
            graph.computeIfAbsent(from, k -> new ArrayList<String>());
            graph.get(from).add(to);
        }

        for (String key : graph.keySet()) {
            Collections.sort(graph.get(key));
        }

        // dfs and backtracking
        itinerary.add("JFK");
        if (backtrack(SOURCE, tickets.size() + 1)) {
            return itinerary;
        }

        return new ArrayList<>();
    }

    public boolean backtrack (String src, int numAirports) {
        if (itinerary.size() == numAirports) {
            return true;
        }

        if (!graph.containsKey(src)) {
            return false;
        }

        List<String> neighbors = new ArrayList<>(graph.get(src));
    List<String> list = graph.get(src);
    for (int i = 0; i < list.size(); i++) {
        String neighbor = list.get(i);

        list.remove(i);
        itinerary.add(neighbor);

        if (backtrack(neighbor, numAirports)) {
            return true;
        }

        list.add(i, neighbor); // restore position
        itinerary.remove(itinerary.size() - 1);
    }

        return false;
    }
}


/*
DFS through until you reach all the nodes
1) build the graph and sort the neighbors to ensure that the lexicographical order is ran through
2) maintain a list of visited nodes
3) dfs through the graph starting at "JFK"
4) remove visited neighbors from the graph when you visit them  
5) if you leave the dfs without reach all the nodes then you return empty list 
*/