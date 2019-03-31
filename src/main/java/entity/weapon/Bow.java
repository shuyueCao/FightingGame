package entity.weapon;

import entity.Weapon;

/**
 * @author phoebegl
 * @Date 2019/3/30.
 */
public class Bow extends Weapon {

    public Bow() {
        this.name="穿云弓";
        this.description="有一定的概率产生暴击, 造成25点伤害";
        this.power=25;
        this.money = 250;
}

    @Override
    public int calculateDPS() {
        return this.power;
    }
}
