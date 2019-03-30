package entity.skill;

import lombok.Data;

import java.util.Observer;

/**
 * created by csy on 2019/3/24
 **/
@Data
public abstract class AbstractSkill1 implements Observer{

    protected String name;
    protected String description;
    protected int level;
    protected int dps;

//    public abstract int calculateDPS();

}
