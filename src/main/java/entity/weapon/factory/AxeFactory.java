package entity.weapon.factory;

import entity.weapon.Axe;
import entity.weapon.Weapon;

/**
 * created by csy on 2019/3/29
 **/
public class AxeFactory implements WeaponFactory{


    public Weapon create() {
        return new Axe();
    }
}
