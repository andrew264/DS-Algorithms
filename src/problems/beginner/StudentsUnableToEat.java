package problems.beginner;

import java.util.ArrayList;

public class StudentsUnableToEat {
    // 1700. Number of Students Unable to Eat Lunch
    //The school cafeteria offers circular and square sandwiches at lunch break, referred to by numbers 0 and 1 respectively. All students stand in a queue. Each student either prefers square or circular sandwiches.
    //
    //The number of sandwiches in the cafeteria is equal to the number of students. The sandwiches are placed in a stack. At each step:
    //
    //If the student at the front of the queue prefers the sandwich on the top of the stack, they will take it and leave the queue.
    //Otherwise, they will leave it and go to the queue's end.
    //This continues until none of the queue students want to take the top sandwich and are thus unable to eat.
    public static int countStudents(int[] students, int[] sandwiches) {
        ArrayList<Integer> studentList = new ArrayList<>();
        ArrayList<Integer> sandwichList = new ArrayList<>();
        for (int i = 0; i < students.length; i++) {
            studentList.add(students[i]);
            sandwichList.add(sandwiches[i]);
        }
        int i = 0;
        while (i < studentList.size()) {
            if (studentList.get(0).equals(sandwichList.get(0))) {
                studentList.remove(0);
                sandwichList.remove(0);
                i = 0;
            } else {
                studentList.add(studentList.remove(0));
                i++;
            }
        }
        return studentList.size();
    }

    public static void main(String[] args) {
        System.out.println(countStudents(new int[]{1, 1, 0, 0}, new int[]{0, 1, 0, 1}));  // 0
        System.out.println(countStudents(new int[]{1, 1, 1, 0, 0, 1}, new int[]{1, 0, 0, 0, 1, 1}));  // 3
    }
}
