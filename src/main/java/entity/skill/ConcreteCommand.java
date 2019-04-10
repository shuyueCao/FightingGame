package entity.skill;

import entity.role.Role;

/**
 * created by csy on 2019/3/30
 **/
public class ConcreteCommand implements Command {

    private Role role;

    public ConcreteCommand(Role role) {
        this.role = role;
    }

    public int execute() {
        return role.attackBySkill1() + role.attackBySkill2();
    }
}
