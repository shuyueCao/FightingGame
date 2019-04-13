package service.impl;


import entity.role.Role;
import service.InfoService;

/**
 * created by csy on 2019/4/12
 **/
public class InfoServiceImpl implements InfoService {

    public static InfoServiceImpl instance;

    public InfoServiceImpl() {
    }

    public static InfoServiceImpl getInstance() {
        if (instance == null) {
            return new InfoServiceImpl();
        }
        return instance;
    }


    public int getAttackValue(Role role) {
        return role.calculateDPS();
    }

    public int getDefendValue(Role role) {
        return role.calculateDefense();
    }

    public int getHP(Role role) {
        return role.calculateHP();
    }

    public int getRoleAttack(Role role) {
        return role.getAttackValue();
    }

    public int getRoleDefense(Role role) {
        return role.getDefendValue();
    }

    public int getRoleHP(Role role) {
        return role.getHP();
    }

}
