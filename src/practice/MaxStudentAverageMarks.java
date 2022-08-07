package practice;

import java.util.Arrays;

/* 
given the number of students n and each student having marks in m subjects.
calculate the average marks of student, neglecting the subject for which class has lowest average in that subject
*/

public class MaxStudentAverageMarks {

    private static String getStudentAverage(int students, int subjects, int[][] marks) {

        // find index of the lowest average subject: return int
        int lowestAverage = 0;
        int lowestAverageIndex = 0;
        for (int i = 0; i < subjects; i++) {
            int sum = 0;
            for (int j = 0; j < students; j++) {
                sum = sum + marks[j][i];
                System.out.println("SUM: " + sum);
            }
            int average = sum / students;
            System.out.println("AVERAGE: " + average);
            if (average < lowestAverage || i == 0) {
                lowestAverage = average;
                lowestAverageIndex = i;
            }
            System.out.println("LowestAverage: " + lowestAverage);
            System.out.println("LowestAverageIndex: " + lowestAverageIndex);
        }

        // calculate student average marks neglecting the marks in above index
        // return int[]

        int[] averageMarksPerStudent = new int[students];
        for (int i = 0; i < students; i++) {
            int sum = 0;
            for (int j = 0; j < subjects; j++) {
                if (j != lowestAverageIndex) {
                    sum = sum + marks[i][j];
                }
            }
            averageMarksPerStudent[i] = sum / (subjects - 1);
        }

        return Arrays.toString(averageMarksPerStudent);
    }

    public static void main(String[] args) {
        int input1 = 4;
        int input2 = 4;
        int[][] input3 = {
                { 1, 2, 3, 4 },
                { 2, 3, 4, 5 },
                { 4, 0, 4, 5 },
                { 3, 1, 3, 2 }
        };

        System.out.println(getStudentAverage(input1, input2, input3));
    }

}
