package entity.monster;

import entity.role.Role;

/**
 * @author phoebegl
 * @Date 2019/4/8.
 */
public class Bird extends Monster {

    public Bird(Role role) {
        this.name = "飞鸟";
        this.attackValue = 10;
        this.HP = 50;
        this.earnExp = 50;
        this.earnMoney = 50;

        this.role = role;
    }
}
