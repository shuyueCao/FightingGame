package service;

import entity.role.Role;

/**
 * created by csy on 2019/4/12
 **/
public interface InfoService {

    int getAttackValue(Role role);

    int getDefendValue(Role role);

    int getHP(Role role);

    int getRoleAttack(Role role);

    int getRoleDefense(Role role);

    int getRoleHP(Role role);

}
