package entity.weapon;

import lombok.Data;

/**
 * created by csy on 2019/3/24
 **/
@Data
public abstract class Weapon {

    protected String name;
    protected String description;
    protected int power;
    protected int money;
    protected int level = 1;


    public abstract int calculateDPS();

    public void enhancePower(int power) {
        this.power += power;
        this.level++;
    }

    public String getBriefDescription() {
        return "等级为"+getLevel()+"级, 攻击力为"+getPower();
    }

    public String getIntroduction() {
        return getDescription() + "。攻击力为" + getPower() + "。价格为" + getMoney() + "元";
    }
}
