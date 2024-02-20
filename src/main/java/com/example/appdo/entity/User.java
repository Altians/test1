package com.example.appdo.entity;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@Builder
@Accessors(chain = true)
public class User implements Serializable {
    public String name;

    public String userId;
    public int age;
}
