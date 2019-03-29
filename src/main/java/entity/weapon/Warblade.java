package entity.weapon;

import lombok.Data;

/**
 * created by csy on 2019/3/25
 **/
@Data
public class Warblade extends Weapon {


    public Warblade(){
        this.name="无尽战刃";
        this.description="有一定的概率产生暴击";
        this.power=20;
    }

    @Override
    public int calculateDPS() {
        return this.power;
    }

}
