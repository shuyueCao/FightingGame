package entity.role.levelup;

import entity.role.Role;

/**
 * @author phoebegl
 * @Date 2019/3/28.
 */
public interface LevelUpStrategy {

    void upgrade(Role role, Integer increExp);
}
