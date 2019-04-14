package entity.monster.factory;

import entity.monster.Bird;
import entity.monster.Monster;
import entity.role.Role;

/**
 * @author phoebegl
 * @Date 2019/4/14.
 */
public class BirdFactory implements MonsterFactory{
    @Override
    public Monster getMonster(Role role) {
        return new Bird(role);
    }
}
