package entity.equip;

import lombok.Data;

/**
 * created by csy on 2019/3/25
 **/
@Data
public class Barde extends Equipment {

    public Barde(){
        this.name = "反伤刺甲";
        this.description = "受到伤害会减少攻击者的移动速度";
        this.defense = 20;
        this.HP = 10;
        this.money = 200;
    }

    public int calculateDefense() {
        return this.defense;
    }

    public int calculateHP() {
        return this.HP;
    }
}
