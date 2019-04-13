package service;

import entity.monster.Monster;
import entity.role.Role;

/**
 * created by csy on 2019/4/12
 **/
public interface FightService {

    Role attack(Role role, Monster monster);

    Role attackBySkill1(Role role, Monster monster);

    Role attackBySkill2(Role role, Monster monster);

    Role attackBySkill3(Role role, Monster monster);

    Role attackByCombination(Role role, Monster monster);

    Role monsterAttack(Role role, Monster monster);
}
