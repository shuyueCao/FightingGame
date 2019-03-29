package entity.weapon.factory;

import entity.weapon.Warblade;
import entity.weapon.Weapon;

/**
 * created by csy on 2019/3/29
 **/
public class WarbladeFactory implements WeaponFactory {

    public Weapon create() {
        return new Warblade();
    }
}
