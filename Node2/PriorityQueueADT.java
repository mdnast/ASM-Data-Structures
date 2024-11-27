import java.util.ArrayList;
import java.util.Comparator;

public class PriorityQueueADT<T> {
    private class Node {
        T data;
        int priority;

        Node(T data, int priority) {
            this.data = data;
            this.priority = priority;
        }
    }

    private ArrayList<Node> heap = new ArrayList<>();

    private int parent(int index) {
        return (index - 1) / 2;
    }

    private int leftChild(int index) {
        return (2 * index) + 1;
    }

    private int rightChild(int index) {
        return (2 * index) + 2;
    }

    private void swap(int i, int j) {
        Node temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    private void heapifyUp(int index) {
        while (index > 0 && heap.get(index).priority > heap.get(parent(index)).priority) {
            swap(index, parent(index));
            index = parent(index);
        }
    }

    private void heapifyDown(int index) {
        int largest = index;
        int left = leftChild(index);
        int right = rightChild(index);

        if (left < heap.size() && heap.get(left).priority > heap.get(largest).priority) {
            largest = left;
        }

        if (right < heap.size() && heap.get(right).priority > heap.get(largest).priority) {
            largest = right;
        }

        if (largest != index) {
            swap(index, largest);
            heapifyDown(largest);
        }
    }

    public void insert(T element, int priority) {
        Node newNode = new Node(element, priority);
        heap.add(newNode);
        heapifyUp(heap.size() - 1);
    }

    public T remove() {
        if (heap.isEmpty()) {
            throw new IllegalStateException("Priority queue is empty.");
        }
        T removedData = heap.get(0).data;
        heap.set(0, heap.remove(heap.size() - 1));
        heapifyDown(0);
        return removedData;
    }

    public T peek() {
        if (heap.isEmpty()) {
            throw new IllegalStateException("Priority queue is empty.");
        }
        return heap.get(0).data;
    }
}
