package com.example.fightinggame.entity;

import lombok.Data;

/**
 * created by csy on 2019/3/24
 **/
@Data
public class Skill {

    private String name;
    private String description;
    private int id;
    private static int level = 1;
    private static int dps = 10;

    public Skill(String name, String description, int id) {
        this.name = name;
        this.description = description;
        this.id = id;
    }
}
