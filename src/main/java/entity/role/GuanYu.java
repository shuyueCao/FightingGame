package entity.role;

import entity.Role;
import lombok.Data;

/**
 * 具体角色类——关羽
 * @author phoebegl
 * @Date 2019/3/28.
 */
@Data
public class GuanYu extends Role {

    public GuanYu() {
        this.attackValue = 150;
        this.defendValue = 70;
        this.HP = 150;
        this.currentHP = 150;
    }
}
