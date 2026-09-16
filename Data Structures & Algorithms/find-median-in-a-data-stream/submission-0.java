class MedianFinder {
    Queue<Integer> left;
    Queue<Integer> right;

    public MedianFinder() {
        this.left = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        this.right = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        // 1 num is greater than right.peek() 
        // 2 num is less than left.peek()

        // take into consideration the size of the both heaps to keep them balanced
        // a left is greater than right list 
        // b right is greater than left list

        // if 1 and a -> push to right
        // if 1 and b -> poll and push min to left and push num to right
        // if 2 and a -> poll and push max to right and push num to left
        // if 2 and b -> push to left

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