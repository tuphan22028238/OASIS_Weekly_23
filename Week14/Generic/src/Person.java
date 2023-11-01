public class Person implements Comparable<Person> {
    protected String name;
    protected int age;
    protected String address;

    public Person() {

    }

    /**
     * Constructor with given parameters.
     * @param name given name
     * @param age given age
     * @param address given address
     */
    public Person(String name, int age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Override the compareTo method in Comparable class.
     * @param p the object to be compared
     * @return the compared result
     */
    public int compareTo(Person p) {
        if (!this.name.equals(p.getName())) {
            return this.name.compareTo(p.getName());
        } else if (this.age != p.getAge()) {
            return Integer.compare(this.age, p.getAge());
        }
        return this.address.compareTo(p.getAddress());
    }


}