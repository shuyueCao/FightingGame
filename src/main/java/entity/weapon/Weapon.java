package entity.weapon;

import lombok.Data;

/**
 * created by csy on 2019/3/24
 **/
@Data
public abstract class Weapon {

    protected String name;
    protected String description;
    protected int power;


    public abstract int calculateDPS();

    public void enhancePower(int power) {
        this.power += power;
    }
}
