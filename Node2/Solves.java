public class Solves {
    public static void main(String[] args) {
        PriorityQueueADT<String> queue = new PriorityQueueADT<>();

        queue.insert("Task A", 3);
        queue.insert("Task B", 5);
        queue.insert("Task C", 1);

        System.out.println("Highest priority: " + queue.peek()); // Task B
        System.out.println("Removing: " + queue.remove());       // Task B
        System.out.println("Highest priority now: " + queue.peek()); // Task A
    }

}
