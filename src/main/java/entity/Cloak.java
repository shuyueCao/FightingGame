package entity;

/**
 * created by csy on 2019/3/25
 **/
public class Cloak extends Equipment {

    public Cloak(){
        this.name = "红莲斗篷";
        this.description = "可以对周围的敌人有持续灼烧效果";
        this.defense = 10;
        this.HP = 20;
    }

    @Override
    public String introduction() {
        return "烧就完事了";
    }
}
