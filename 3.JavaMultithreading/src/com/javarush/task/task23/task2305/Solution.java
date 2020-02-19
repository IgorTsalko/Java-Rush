package com.javarush.task.task23.task2305;

import java.util.Arrays;

/*
Inner
*/
public class Solution {
    public InnerClass[] innerClasses = new InnerClass[2];

    public class InnerClass {
    }

    public static Solution[] getTwoSolutions() {
        Solution[] solutions = new Solution[2];
        Solution solution1 = new Solution();
        Solution solution2 = new Solution();
        solution1.innerClasses[0] = solution1.new InnerClass();
        solution1.innerClasses[1] = solution1.new InnerClass();
        solution2.innerClasses[0] = solution2.new InnerClass();
        solution2.innerClasses[1] = solution2.new InnerClass();
        solutions[0] = solution1;
        solutions[1] = solution2;
        return solutions;
    }

    public static void main(String[] args) {
        System.out.println(getTwoSolutions()[0]);
        System.out.println(getTwoSolutions()[1]);

        System.out.println(getTwoSolutions()[0].innerClasses[0]);
        System.out.println(getTwoSolutions()[0].innerClasses[1]);

        System.out.println(getTwoSolutions()[1].innerClasses[0]);
        System.out.println(getTwoSolutions()[1].innerClasses[1]);

    }
}
