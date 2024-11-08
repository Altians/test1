package com.example.appdo.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.List;
import java.util.Scanner;

/**
 * @Author: crh
 * @CreateDate: 2024/7/7
 * @Description:
 */
@Data
public class Demo implements Serializable {
    private List<User> users;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入一个数：");
        String input = scanner.next();

        if (!input.matches("^[0-9]+(\\.[0-9]+)?$")) {
            System.out.println("是非负数。");
        } else {
            System.out.println("不是非负数。");
        }

//        scanner.close();
    }
}
