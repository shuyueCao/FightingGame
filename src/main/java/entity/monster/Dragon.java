package entity.monster;

import entity.role.Role;

/**
 * @author phoebegl
 * @Date 2019/4/8.
 */
public class Dragon extends Monster {

    public Dragon(Role role) {
        this.name = "大龙";
        this.attackValue = 50;
        this.HP = 200;
        this.earnExp = 350;
        this.earnMoney = 350;
        this.role = role;
    }
}
