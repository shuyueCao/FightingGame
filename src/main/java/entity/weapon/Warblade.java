package entity.weapon;

import entity.Weapon;
import lombok.Data;

/**
 * created by csy on 2019/3/25
 **/
@Data
public class Warblade extends Weapon {


    public Warblade(){
        this.name="无尽战刃";
        this.description="有一定的概率产生暴击, 造成20点伤害";
        this.power=20;
        this.money = 200;
    }

    @Override
    public int calculateDPS() {
        return this.power;
    }

}
