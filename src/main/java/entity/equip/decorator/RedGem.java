package entity.equip.decorator;

import entity.equip.Equipment;
import lombok.Data;

/**
 * created by csy on 2019/3/29
 **/
@Data
public class RedGem extends GemDecorator {

    private Equipment equipment;

    private RedGem(Equipment equipment) {
        this.equipment = equipment;
        this.defense = 10;
        this.HP = 10;
        this.description = "红宝石";
    }

    public int calculateDefense() {
        equipment.setDefense(this.defense + equipment.calculateDefense());

        return equipment.getDefense();
    }

    public int calculateHP() {
        equipment.setHP(this.HP + equipment.calculateHP());
        return equipment.getHP();
    }

    protected String showDescription() {
        return equipment.getDescription() + " + " + this.description;
    }
}
