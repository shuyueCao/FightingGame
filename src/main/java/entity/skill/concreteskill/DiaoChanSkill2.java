package entity.skill.concreteskill;

import entity.role.Role;
import entity.skill.AbstractSkill2;
import lombok.Data;

import java.util.Observable;

/**
 * created by csy on 2019/3/30
 **/
@Data
public class DiaoChanSkill2 extends AbstractSkill2 {

    public DiaoChanSkill2() {
        this.level = 1;
        this.name = "缘心结";
        this.description = "貂蝉瞬间消失并立即出现在指定位置，同时会散发3枚花球攻击附近的敌人";
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
