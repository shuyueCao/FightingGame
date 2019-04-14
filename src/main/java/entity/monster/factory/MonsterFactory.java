package entity.monster.factory;

import entity.monster.Monster;
import entity.role.Role;

/**
 * @author phoebegl
 * @Date 2019/4/14.
 */
public interface MonsterFactory {

    Monster getMonster(Role role);
}
