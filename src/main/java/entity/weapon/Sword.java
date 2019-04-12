package entity.weapon;

/**
 * @author phoebegl
 * @Date 2019/3/30.
 */
public class Sword extends Weapon {

    public Sword(){
        this.name="匕首";
        this.description="有一定的概率产生暴击, 造成10点伤害";
        this.power=10;
        this.money = 100;
    }

    @Override
    public int calculateDPS() {
        return this.power;
    }
}
