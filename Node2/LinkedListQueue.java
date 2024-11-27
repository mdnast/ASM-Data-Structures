class Node2 {
    int data;
    Node next;

    public Node2(int data) {
        this.data = data;
        this.next = null;
    }
}

public class LinkedListQueue {
    private Node front, rear;

    public LinkedListQueue() {
        front = rear = null;
    }

    // Enqueue operation
    public void enqueue(int item) {
        Node newNode = new Node(item);
        if (rear == null) {
            front = rear = newNode;
            return;
        }
        rear.next = newNode;
        rear = newNode;
    }

    // Dequeue operation
    public int dequeue() {
        if (front == null) {
            System.out.println("Queue is empty!");
            return Integer.MIN_VALUE;
        }
        int item = front.data;
        front = front.next;
        if (front == null) rear = null;
        return item;
    }

    // Peek operation
    public int peek() {
        if (front == null) {
            System.out.println("Queue is empty!");
            return Integer.MIN_VALUE;
        }
        return front.data;
    }

    // Check if the queue is empty
    public boolean isEmpty() {
        return front == null;
    }
}
