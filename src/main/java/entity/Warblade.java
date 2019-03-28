package entity;

import lombok.Data;

import java.awt.font.TextHitInfo;

/**
 * created by csy on 2019/3/25
 **/
@Data
public class Warblade extends Weapon {


    public Warblade(){
        this.name="无尽战刃";
        this.description="有一定的概率产生暴击";
        this.level=1;
        this.power=20;
    }

    @Override
    public String introduction() {
        return "一波暴击教你做人";
    }

    @Override
    public int calculateDPS() {
        return 0;
    }

}
