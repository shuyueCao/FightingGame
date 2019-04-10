package entity.skill.concreteskill;

import entity.skill.AbstractSkill2;

import java.util.Observable;

/**
 * created by csy on 2019/4/10
 **/
public class GuanYuSkill2 extends AbstractSkill2 {

    public GuanYuSkill2(){
        this.level = 1;
        this.name = "青龙偃月";
        this.description = "关羽清啸一声，解除自身控制效果并向前跃击敌人将其击退，造成伤害";
        this.dps = 5;
    }


    public void update(Observable o, Object arg) {

    }
}
