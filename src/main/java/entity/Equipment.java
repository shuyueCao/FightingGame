package entity;

import lombok.Data;

/**
 * created by csy on 2019/3/25
 **/
@Data
public abstract class Equipment {

    public String name;
    public String description;
    public int defense;
    public int HP;

    public abstract String introduction();
}
