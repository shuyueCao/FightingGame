package entity.weapon.factory;

import entity.Weapon;

/**
 * created by csy on 2019/3/29
 **/
public interface WeaponFactory {

    /**
     * 创建武器
     * @return
     */
    Weapon create();

}
