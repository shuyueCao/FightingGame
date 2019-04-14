package entity.skill;

import entity.role.Role;

/**
 * created by csy on 2019/3/30
 **/
public class ConcreteCommand implements Command {

    private Role role;
    private final int extraDPS = 5;

    public ConcreteCommand(Role role) {
        this.role = role;
    }

    public int execute() {
        int dps2 = role.getSkill2() == null ? 0 : role.getSkill2().getDps();
//        if (dps2 == 0)
//            return role.getSkill1().getDps();
        return role.getSkill1().getDps() + dps2 + extraDPS;
    }
}
