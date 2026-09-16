class MedianFinder {
    Queue<Integer> left;
    Queue<Integer> right;

    public MedianFinder() {
        this.left = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        this.right = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        if (left.size() == 0 || left.peek() >= num) {
            left.add(num);
        } else {
            right.add(num);
        }

        if (left.size() > right.size() + 1) {
            right.add(left.poll());
        } else if (right.size() > left.size() + 1) {
            left.add(right.poll());
        }
    }
    
    public double findMedian() {
        if (left.size() == right.size()) {
            return (double) (left.peek() + right.peek()) / 2;
        } else if (right.size() > left.size()) {
            return (double) right.peek();
        } else {
            return (double) left.peek();
        }
    }
}