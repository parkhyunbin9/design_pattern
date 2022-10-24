package study.design_pattern.behavior.strategy.useCase.Java;

import lombok.Data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Comparator {

    private static List<Student> studentList = new ArrayList<>();
    private static java.util.Comparator<? super Student> ScoreComparator;
    private static java.util.Comparator<? super Student> HeightComparator;
    public static void main(String[] args) {
        init();


        
        System.out.println("정렬 전 : ");
        System.out.println(studentList);
        studentList.sort(new ScoreComparator());
        System.out.println("점수 기준 정렬 후 : ");  // 점수 기준 정렬 채택
        System.out.println(studentList);

        System.out.println("키 기준 정렬 후 : ");
        studentList.sort(new HeightComparator());   // 키 기준 정렬 채택
        System.out.println(studentList);


    }

    @Data
    static class Student {
        int score;
        int height;

        public Student(int score, int height) {
            this.score = score;
            this.height = height;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "score=" + score +
                    ", height=" + height +
                    '}';
        }
    }


    public static void init() {
        studentList.add(new Student(100, 180));
        studentList.add(new Student(80, 183));
        studentList.add(new Student(60, 186));
        studentList.add(new Student(70, 176));
    }


}

 class ScoreComparator implements java.util.Comparator {

    @Override
    public int compare(Object o1, Object o2) {
        Comparator.Student student1 = (Comparator.Student) o1;
        Comparator.Student student2 = (Comparator.Student) o2;
        return student1.getScore() - student2.getScore();
    }
}

class HeightComparator implements java.util.Comparator {

    @Override
    public int compare(Object o1, Object o2) {
        Comparator.Student student1 = (Comparator.Student) o1;
        Comparator.Student student2 = (Comparator.Student) o2;
        return student1.getHeight() - student2.getHeight();
    }
}