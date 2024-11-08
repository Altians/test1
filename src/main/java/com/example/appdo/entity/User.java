package com.example.appdo.entity;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @Author: crh
 * @CreateDate: 2024/5/28
 * @Description:
 */
@Data
public class User implements Serializable {
    private String name;

    private String userId;
    private Integer age;


}
