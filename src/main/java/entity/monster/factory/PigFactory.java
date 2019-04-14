package entity.monster.factory;

import entity.monster.Monster;
import entity.monster.Pig;
import entity.role.Role;

/**
 * @author phoebegl
 * @Date 2019/4/14.
 */
public class PigFactory implements MonsterFactory{
    @Override
    public Monster getMonster(Role role) {
        return new Pig(role);
    }
}
