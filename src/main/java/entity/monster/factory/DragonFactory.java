package entity.monster.factory;

import entity.monster.Dragon;
import entity.monster.Monster;
import entity.role.Role;

/**
 * @author phoebegl
 * @Date 2019/4/14.
 */
public class DragonFactory implements MonsterFactory{
    @Override
    public Monster getMonster(Role role) {
        return new Dragon(role);
    }
}
