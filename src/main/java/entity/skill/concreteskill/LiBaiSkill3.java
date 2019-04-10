package entity.skill.concreteskill;

import entity.skill.AbstractSkill3;

import java.util.Observable;

/**
 * created by csy on 2019/4/10
 **/
public class LiBaiSkill3 extends AbstractSkill3 {

    public LiBaiSkill3(){
        this.level = 1;
        this.name = "青莲剑歌";
        this.description = "李白化身为剑气，对指定方向范围内的所有敌人飞速穿梭斩击5次，每次斩击造成物理伤害，李白释放技能期间不可被选中和攻击";
        this.dps = 5;
    }

    public void update(Observable o, Object arg) {

    }
}
