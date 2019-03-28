package entity.role.levelup;

import entity.Role;

/**
 * @author phoebegl
 * @Date 2019/3/28.
 */
public interface LevelUpStrategy {

    void upgrate(Role role, Integer increExp);
}
