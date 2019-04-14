package entity.monster.factory;

import entity.monster.Monster;
import entity.monster.Snake;
import entity.role.Role;

/**
 * @author phoebegl
 * @Date 2019/4/14.
 */
public class SnakeFactory implements MonsterFactory{
    @Override
    public Monster getMonster(Role role) {
        return new Snake(role);
    }
}
