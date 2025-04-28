package oop.mylist;

public class StudentStatistics {
    private MyList students;

    public StudentStatistics(MyList students) {
        this.students = students;
    }

    public MyList sortByAverage(boolean ascending) {
        MyArrayList sorted = new MyArrayList();
        for (int i = 0; i < students.size(); i++) {
            Student s = (Student) students.get(i);
            int insertIndex = 0;
            while (insertIndex < sorted.size() &&
                    (ascending
                            ? ((Student) sorted.get(insertIndex)).getAverage() < s.getAverage()
                            : ((Student) sorted.get(insertIndex)).getAverage() > s.getAverage())) {
                insertIndex++;
            }
            sorted.insert(s, insertIndex);
        }
        return sorted;
    }

    public MyList sortByFullname(boolean ascending) {
        MyArrayList sorted = new MyArrayList();
        for (int i = 0; i < students.size(); i++) {
            Student s = (Student) students.get(i);
            int insertIndex = 0;
            while (insertIndex < sorted.size() &&
                    (ascending
                            ? ((Student) sorted.get(insertIndex)).toString().compareTo(s.toString()) < 0
                            : ((Student) sorted.get(insertIndex)).toString().compareTo(s.toString()) > 0)) {
                insertIndex++;
            }
            sorted.insert(s, insertIndex);
        }
        return sorted;
    }
}