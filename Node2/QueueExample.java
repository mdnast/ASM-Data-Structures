public class QueueExample {
    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue(3);

        queue.enqueue(1); // Enqueue Customer A
        queue.enqueue(2); // Enqueue Customer B
        queue.enqueue(3); // Enqueue Customer C

        System.out.println("Front customer: " + queue.peek()); // Peek: Customer A

        System.out.println("Dequeue: " + queue.dequeue()); // Serve Customer A
        System.out.println("Dequeue: " + queue.dequeue()); // Serve Customer B

        queue.enqueue(4); // Enqueue Customer D
        System.out.println("Front customer: " + queue.peek()); // Peek: Customer C
    }
}
