package entity.equip;

import lombok.Data;

/**
 * created by csy on 2019/3/25
 **/
@Data
public class Cloak extends Equipment {

    public Cloak(){
        this.name = "红莲斗篷";
        this.description = "可以对周围的敌人有持续灼烧效果";
        this.defense = 10;
        this.HP = 20;
        this.money = 300;
    }


    public int calculateDefense() {
        return this.defense;
    }

    public int calculateHP() {
        return this.HP;
    }
}
