package pl.mateusz.stubs;

public class Person {
    private static Long lastId = 0L;
    private Long id;
    private String name;
    private String lastName;
    private int age;

    public Person(String name, String lastName, int age) {
        lastId++;
        this.id = lastId;
        this.name = name;
        this.lastName = lastName;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                '}';
    }

    public int getAge() {
        return age;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }
}
