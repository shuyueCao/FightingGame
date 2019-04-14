package entity.monster;

import entity.role.Role;

/**
 * @author phoebegl
 * @Date 2019/4/8.
 */
public class Snake extends Monster {

    public Snake(Role role) {
        this.name = "毒蛇";
        this.attackValue = 35;
        this.HP = 150;
        this.earnExp = 200;
        this.earnMoney = 200;
        this.role = role;
    }
}
