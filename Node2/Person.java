public class Person {
    // Private fields to store personal information
    private String name;
    private int age;

    // Constructor to initialize the person
    public Person(String name, int age) {
        this.name = name;
        if (age > 0) { // Validate age
            this.age = age;
        } else {
            this.age = 0; // Default to 0 if invalid age is given
        }
    }

    // Public method to get the name
    public String getName() {
        return name;
    }

    // Public method to set the name
    public void setName(String name) {
        if (name != null && !name.isEmpty()) { // Validate name
            this.name = name;
        } else {
            System.out.println("Invalid name.");
        }
    }

    // Public method to get the age
    public int getAge() {
        return age;
    }

    // Public method to set the age
    public void setAge(int age) {
        if (age > 0) { // Validate age
            this.age = age;
        } else {
            System.out.println("Invalid age.");
        }
    }

    // Public method to display personal information
    public void displayInfo() {
        System.out.println("Name: " + name + ", Age: " + age);
    }
}
