package entity.equip.decorator;

import entity.equip.Equipment;

/**
 * created by csy on 2019/3/29
 **/

/**
 * 装备镶嵌宝石改变属性值，采用装饰者模式
 */
public abstract class GemDecorator extends Equipment {

    public abstract String showDescription();

}
