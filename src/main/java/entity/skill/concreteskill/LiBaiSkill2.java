package entity.skill.concreteskill;

import entity.role.Role;
import entity.skill.AbstractSkill2;
import lombok.Data;

import java.awt.geom.Line2D;
import java.util.Observable;

/**
 * created by csy on 2019/4/10
 **/
@Data
public class LiBaiSkill2 extends AbstractSkill2 {

    public LiBaiSkill2(){
        this.level = 1;
        this.name = "神来之笔";
        this.description = "以自身为中心化剑为青莲剑阵，对范围内敌人造成物理伤害；对触碰到剑圈的敌人造成物理伤害并且减少其移动速度。李白释放技能期间不可被选中";
        this.dps = 5;
    }

    public void update(Observable o, Object arg) {
        Role role = (Role) o;
        if (role.getLevel() % 10 == 0) {
            this.dps += 10;
        } else {
            this.dps += 5;
        }
        this.level++;
        System.out.println("角色等级为：" + role.getLevel()+",二技能升级");
    }
}
