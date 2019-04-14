package entity.role;

import entity.skill.concreteskill.GuanYuSkill1;
import entity.skill.concreteskill.GuanYuSkill2;
import entity.skill.concreteskill.GuanYuSkill3;
import lombok.Data;

/**
 * 具体角色类——关羽
 * @author phoebegl
 * @Date 2019/3/28.
 */
@Data
public class GuanYu extends Role {

    public GuanYu() {
        this.name = "关羽";
        this.attackValue = 6;
        this.defendValue = 6;
        this.HP = 150;
        this.currentHP = this.HP;
//        this.weapon = new Bow();
        this.skill1 = new GuanYuSkill1();
        this.addObserver(skill1);
        this.abstractSkill2 = new GuanYuSkill2();
        this.abstractSkill3 = new GuanYuSkill3();
    }
}
