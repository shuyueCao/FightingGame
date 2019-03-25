package com.example.fightinggame.entity;

import lombok.Data;

/**
 * created by csy on 2019/3/24
 **/
@Data
public abstract class Weapon {

    protected String name;
    protected String description;
    protected int level;
    protected int power;

    public abstract String introduction();

    public abstract void Attack();
}
