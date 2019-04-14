package entity.monster;

import entity.role.Role;

/**
 * @author phoebegl
 * @Date 2019/4/8.
 */
public class Pig extends Monster {

    public Pig(Role role) {
        this.name = "野猪";
        this.attackValue = 20;
        this.HP = 100;
        this.earnExp = 100;
        this.earnMoney = 100;
        this.role = role;
    }
}
