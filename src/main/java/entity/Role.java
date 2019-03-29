package entity;

import entity.equip.Equipment;
import entity.weapon.Weapon;
import lombok.Data;

import java.util.List;

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
    protected Integer HP;
    protected Integer currentHP;
    protected Integer experience = 0;
    protected Integer money = 500;
    protected Integer level = 1;

    //只可携带一件武器
    protected Weapon weapon;
    //最多携带3件装备
    protected List<Equipment> equipmentList;
    //三个技能
    protected Skill skill1;
    protected Skill skill2;
    protected Skill skill3;

}
