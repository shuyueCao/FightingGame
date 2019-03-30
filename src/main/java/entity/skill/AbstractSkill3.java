package entity.skill;

import lombok.Data;

import java.util.Observer;

/**
 * created by csy on 2019/3/30
 **/
@Data
public abstract class AbstractSkill3 implements Observer{

    protected String name;
    protected String description;
    protected int level;
    protected int dps;


}
