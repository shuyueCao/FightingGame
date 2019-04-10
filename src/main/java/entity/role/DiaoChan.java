package entity.role;

import entity.weapon.Sword;
import lombok.Data;

/**
 * 具体角色类——貂蝉
 * @author phoebegl
 * @Date 2019/3/28.
 */
@Data
public class DiaoChan extends Role{

    public DiaoChan() {
        this.name = "貂蝉";
        this.attackValue = 80;
        this.defendValue = 130;
        this.HP = 100;
        this.currentHP = 100;
        this.weapon = new Sword();
    }

}
