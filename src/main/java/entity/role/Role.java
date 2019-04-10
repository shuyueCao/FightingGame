package entity.role;

import entity.Weapon;
import entity.equip.Equipment;
import entity.skill.AbstractSkill1;
import entity.skill.AbstractSkill2;
import entity.skill.AbstractSkill3;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

/**
 *
 * @author phoebegl
 * @Date 2019/3/24.
 */
@Data
public abstract class Role extends Observable {

    protected String name;
    protected Integer defendValue;
    protected Integer attackValue;
    protected Integer HP;
    protected Integer currentHP;
    protected Integer experience = 0;
    protected Integer money = 500;
    protected Integer level = 1;

    //只可携带一件武器
    protected Weapon weapon;
    //最多携带3件装备
    protected List<Equipment> equipmentList = new ArrayList<Equipment>();
    //三个技能
    protected AbstractSkill1 skill1;
    protected AbstractSkill2 skill2;
    protected AbstractSkill3 skill3;


    public int attackBySkill1(){
        return skill1.getDps();
    }

    public int attackBySkill2(){
        return skill2.getDps();
    }

    public int attackBySkill3(){
        return skill3.getDps();
    }

}