package com.example.fightinggame.Factory.weapon;

import com.example.fightinggame.entity.Warblade;
import com.example.fightinggame.entity.Weapon;

/**
 * created by csy on 2019/3/25
 **/
public class WarbladeFactory implements WeaponFactory {
    @Override
    public Weapon buyWeapon() {
        return new Warblade();
    }
}
