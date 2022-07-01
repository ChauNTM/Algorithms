package main.java.cmnguyen.problems.hard;

public class Main {
    public static void main(String[] args) {
        courseScheduleV3();
    }

    static private void courseScheduleV3() {
//        int[][] courses = new int[][]{{100,200},{200,1300},{1000,1250},{2000,3200}};
        int[][] courses = new int[][]{{1,2}};
        System.out.println("maximum number of courses " + CourseScheduleV3.scheduleCourse(courses));
    }
}
