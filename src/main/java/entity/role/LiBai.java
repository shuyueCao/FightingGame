package entity.role;

import entity.Role;
import lombok.Data;

/**
 * 具体的角色实现类——李白
 * @author phoebegl
 * @Date 2019/3/25.
 */
@Data
public class LiBai extends Role {

    public LiBai() {
        this.attackValue = 120;
        this.defendValue = 100;
        this.HP = 100;
        this.currentHP = 100;
    }
}