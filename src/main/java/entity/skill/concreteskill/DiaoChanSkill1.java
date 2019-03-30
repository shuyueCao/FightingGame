package entity.skill.concreteskill;

import entity.skill.AbstractSkill1;
import lombok.Data;

import java.util.Observable;
import java.util.Observer;

/**
 * created by csy on 2019/3/30
 **/
@Data
public class DiaoChanSkill1 extends AbstractSkill1 {

    public DiaoChanSkill1() {
        this.level = 1;
        this.name = "落红雨";
        this.description = "向指定方向挥出花球，花球飞出一段时间后会返回貂蝉手中，挥出和返回会对路径上的敌人造成伤害";
        this.dps = 5;
    }

    public void update(Observable o, Object arg) {
        this.level++;
        this.dps += 5;
    }
}
