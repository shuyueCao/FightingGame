package entity.role;

import entity.skill.concreteskill.LiBaiSkill1;
import entity.skill.concreteskill.LiBaiSkill2;
import entity.skill.concreteskill.LiBaiSkill3;
import lombok.Data;

/**
 * 具体的角色实现类——李白
 * @author phoebegl
 * @Date 2019/3/25.
 */
@Data
public class LiBai extends Role {

    public LiBai() {
        this.name = "李白";
        this.attackValue = 8;
        this.defendValue = 5;
        this.HP = 100;
        this.currentHP = this.HP;
//        this.weapon = new Warblade();
        this.skill1 = new LiBaiSkill1();
        this.addObserver(skill1);
        this.abstractSkill2 = new LiBaiSkill2();
        this.abstractSkill3 = new LiBaiSkill3();
    }
}
