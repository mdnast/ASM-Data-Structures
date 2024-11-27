public class main {
    public static void main(String[] args) {
        PriorityQueueADT<String> queue = new PriorityQueueADT<>();

        try {
            queue.remove(); // Should throw an exception
        } catch (IllegalStateException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }


}
