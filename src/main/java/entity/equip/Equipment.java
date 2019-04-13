package entity.equip;

import lombok.Data;

/**
 * created by csy on 2019/3/25
 **/
@Data
public abstract class Equipment {

    protected String name;
    protected String description;
    protected int defense;
    protected int HP;
    protected int money;

    /**
     * 计算防御值
     * @return
     */
    public abstract int calculateDefense();


    /**
     * 计算血量
     * @return
     */
    public abstract int calculateHP();

    public String getIntroduction() {
        return getDescription() + "。防御值为" + calculateDefense()
                + "。可增加血量" + calculateHP() + "。价格为" + getMoney() + "元";
    }
}
