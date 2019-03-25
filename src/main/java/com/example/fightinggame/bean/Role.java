package com.example.fightinggame.bean;

import lombok.Data;

/**
 *
 * @author phoebegl
 * @Date 2019/3/24.
 */
@Data
public abstract class Role {

    protected String name;
    protected Integer defendValue;
    protected Integer attackValue;
    protected Integer hp;
    protected Integer experience;
    protected Integer money;

    //TODO 武器,装备,技能属性
}
