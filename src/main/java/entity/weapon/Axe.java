package entity.weapon;

import lombok.Data;

/**
 * created by csy on 2019/3/25
 **/
@Data
public class Axe extends Weapon {


    public Axe(){
        this.name="暗影战斧";
        this.description = "有一定几率降低敌人移动速度, 造成50点伤害";
        this.power=50;
        this.money = 500;
    }


    @Override
    public int calculateDPS() {
        return this.power;
    }

}
