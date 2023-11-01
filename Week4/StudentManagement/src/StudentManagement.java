public class StudentManagement {

    private final Student []students = new Student[100];
    public int numberOfStudents = 0;

    /**
     * Testing whether the two given students are in the same group.
     * @param s1 the first student in comparison
     * @param s2 the latter student in comparison
     * @return true if they are in the same group, else false
     */
    public static boolean sameGroup(Student s1, Student s2) {
        return (s1.getGroup().equals(s2.getGroup())); // xoa dong nay sau khi cai dat
    }

    /**
     * Add new students in the record.
     * @param newStudent the instance that have information of the new student
     */
    public void addStudent(Student newStudent) {
        students[numberOfStudents++] = newStudent;
    }

    /**
     * Create the record of all student sorted by the group.
     * @return the string of all student sorted by the group
     */
    public String studentsByGroup() {
        String result = "";
        String groupName;
        boolean []isRecorded = new boolean[100];
        for (int i = 0; i < 100; i++) {
            isRecorded[i] = false;
        }

        for (int i = 0; i < numberOfStudents; i++) {
            if (!isRecorded[i]) {
                groupName = students[i].getGroup();
                result += groupName;
                result += "\n";
                for (int j = i; j < numberOfStudents; j++) {
                    if (students[j].getGroup().equals(groupName)) {
                        String tmp  = students[j].getInfo() + "\n";
                        result += tmp;
                        isRecorded[j] = true;
                    }
                }
            }
        }
        return result;
    }

    /**
     * remove the student required by the given id.
     * @param id the id of the student wanting to remove
     */
    public void removeStudent(String id) {
        for (int i = 0; i < numberOfStudents; i++) {
            if (students[i].getId().equals(id)) {
                for (int j = i; j < numberOfStudents - 1; j++) {
                    students[j] = students[j + 1];
                }
                numberOfStudents--;
                break;
            }
        }
    }
}
