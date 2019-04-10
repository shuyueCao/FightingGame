package entity.skill.concreteskill;

import entity.skill.AbstractSkill3;

import java.util.Observable;

/**
 * created by csy on 2019/4/10
 **/
public class GuanYuSkill3 extends AbstractSkill3 {

    public GuanYuSkill3(){
        this.level = 1;
        this.name = "刀锋铁骑";
        this.description = "关羽将召唤铁骑向前方突击撞退敌人，并造成伤害";
        this.dps = 10;
    }

    public void update(Observable o, Object arg) {

    }
}
