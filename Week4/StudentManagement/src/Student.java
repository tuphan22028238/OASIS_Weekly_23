public class Student {
    private String name;
    private String id;
    private String group;
    private String email;

    public String getName() {
        //get the string represents name of the instance
        return name;
    }

    public void setName(String name) {
        //set name of the instance
        this.name = name;
    }

    public String getId() {
        //get ID of the instance
        return id;
    }

    public void setId(String id) {
        //set ID of the instance
        this.id = id;
    }

    public String getGroup() {
        //get group of the instance
        return group;
    }

    public void setGroup(String group) {
        //set group of the instance
        this.group = group;
    }

    public String getEmail() {
        //get email of the instance
        return email;
    }

    public void setEmail(String email) {
        //set email of the instance
        this.email = email;
    }

    Student() {
        //Default constructor that initializes an instance with default values
        name = "Student";
        id = "000";
        group = "K62CB";
        email = "uet@vnu.edu.vn";
    }

    /**
     * Default constructor that initializes an instance.
     * @param name name of the instance
     * @param id id of the instance
     * @param email email of the instance
     */
    Student(String name, String id, String email) {
        //Default constructor that initializes an instance
        this.name = name;
        this.id = id;
        this.email = email;
        group = "K62CB";
    }

    /**
     * Constructor that initialize the instance with the value of given instance.
     * @param s the given instance
     */
    public Student(Student s) {
        //Constructor that initialize the instance with the value of given instance
        this.name = s.name;
        this.id = s.id;
        this.group = s.group;
        this.email = s.email;
    }

    /**
     Constructor that initializes a student object with the given parameters.
     *
     * @param name  the name of the student
     * @param id  the ID of the student
     * @param group  the group of the student
     * @param email  the email of the student
     */
    Student(String name, String id, String group, String email) {
        // constructor that initializes a student object with the given parameters
        this.name = name;
        this.id = id;
        this.group = group;
        this.email = email;
    }

    /**
     * get full information of the instance encompasses: name, id, group and email.
     * @return info the string of full information that separates each other by the hyphen
     */
    public String getInfo() {
        String info = name + " - " + id + " - " + group + " - " + email;
        return info;
    }
}
