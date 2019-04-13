package entity.skill.concreteskill;

import entity.role.GuanYu;
import entity.role.Role;
import entity.skill.AbstractSkill1;
import lombok.Data;

import java.util.Observable;

/**
 * created by csy on 2019/4/10
 **/
@Data
public class GuanYuSkill1 extends AbstractSkill1 {

    public GuanYuSkill1(){
        this.level = 1;
        this.name = "单刀赴会";
        this.description = "关羽向前冲锋造成伤害，并在结束时向前劈砍";
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
        System.out.println("角色等级为：" + role.getLevel()+",一技能升级");
    }
}
