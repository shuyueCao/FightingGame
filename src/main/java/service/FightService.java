package service;

import entity.monster.Monster;
import entity.role.Role;

/**
 * created by csy on 2019/4/12
 **/
public interface FightService {

    Monster createMonster(Role role, int times);

    String attack(Role role, Monster monster);

    String attackBySkill1(Role role, Monster monster);

    String attackBySkill2(Role role, Monster monster);

    String attackBySkill3(Role role, Monster monster);

    String attackByCombination(Role role, Monster monster);
}
