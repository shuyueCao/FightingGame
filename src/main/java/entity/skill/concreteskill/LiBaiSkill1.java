package entity.skill.concreteskill;

import com.sun.javaws.jnl.LibraryDesc;
import entity.skill.AbstractSkill1;

import java.util.Observable;

/**
 * created by csy on 2019/4/10
 **/
public class LiBaiSkill1 extends AbstractSkill1 {

    public LiBaiSkill1(){
        this.level = 1;
        this.name = "将进酒";
        this.description = "李白可用醉剑式向指定方向连续突进2次，对路径上的敌人造成物理伤害并且造成晕眩。第三次释放会回到原地每次释放间隔不能超过5秒";
        this.dps = 5;
    }

    public void update(Observable o, Object arg) {
        this.level++;
        this.dps += 5;
    }
}
