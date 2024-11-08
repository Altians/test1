package com.example.appdo.utils;

/**
 * @Author: crh
 * @CreateDate: 2024/6/15
 * @Description:
 */

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class NumberUtils {
    public static boolean isConsecutive(int[] numbers) {
        // 步骤1：按升序排序
        Arrays.sort(numbers);
        System.out.println("排序后的数组：" + Arrays.toString(numbers));
        // 步骤2：检查是否有重复的数字
        for (int i = 0; i < numbers.length - 1; i++) {
            if (numbers[i] == numbers[i + 1]) {
                System.out.println("存在重复数字");
                return false;
            }
        }

        // 步骤3：判断最大值和最小值的差是否等于数字个数减1
        int min = numbers[0];
        int max = numbers[numbers.length - 1];
        System.out.println("连续");
        return (max - min) == (numbers.length - 1);
    }

    /*public static void main(String[] args) {
        int[] numbers = {2, 1,3, 4, 5};
        boolean result = isConsecutive(numbers);
        System.out.println("Numbers are consecutive: " + result);
    }*/
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(10, 21, 30, 4, 5);
        int[] array = list.stream().mapToInt(Integer::intValue).toArray();
        Arrays.sort(list.toArray(), Collections.reverseOrder());
        Collections.sort(list);
        Integer[] a = {9, 8, 7, 2, 3, 4, 1, 0, 6, 5};
        //Arrays.sort(a);//升序
        Arrays.sort(a,Collections.reverseOrder());//降序
        System.out.println(list);
    }
}
