package entity.role;

import entity.skill.concreteskill.DiaoChanSkill1;
import entity.skill.concreteskill.DiaoChanSkill2;
import entity.skill.concreteskill.DiaoChanSkill3;
import entity.weapon.Sword;
import lombok.Data;

/**
 * 具体角色类——貂蝉
 * @author phoebegl
 * @Date 2019/3/28.
 */
@Data
public class DiaoChan extends Role{

    public DiaoChan() {
        this.name = "貂蝉";
        this.attackValue = 8;
        this.defendValue = 4;
        this.HP = 100;
        this.currentHP = 100;
//        this.weapon = new Sword();
        this.skill1 = new DiaoChanSkill1();
        this.addObserver(skill1);
        this.abstractSkill2 = new DiaoChanSkill2();
        this.abstractSkill3 = new DiaoChanSkill3();
    }

}
