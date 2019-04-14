package entity.role;

import entity.equip.Equipment;
import entity.monster.Monster;
import entity.role.levelstate.LevelHighState;
import entity.role.levelstate.LevelThreeState;
import entity.role.levelstate.LevelTwoState;
import entity.role.levelstate.State;
import entity.role.levelup.ConcreteLevelUpStrategy;
import entity.role.levelup.LevelUpStrategy;
import entity.skill.*;
import entity.weapon.Weapon;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

/**
 * @author phoebegl
 * @Date 2019/3/24.
 */
@Data
public abstract class Role extends Observable {

    protected String name;
    protected Integer defendValue;
    protected Integer attackValue;
    protected Integer HP;
    protected Integer currentHP;
    protected Integer experience = 0;
    protected Integer money = 500;
    protected Integer level = 1;

    //只可携带一件武器
    protected Weapon weapon;
    //最多携带3件装备
    protected List<Equipment> equipmentList = new ArrayList<>();
    //三个技能
    protected AbstractSkill1 skill1;
    protected AbstractSkill2 skill2;
    protected AbstractSkill3 skill3;

    //未解锁技能
    protected AbstractSkill2 abstractSkill2;
    protected AbstractSkill3 abstractSkill3;

    //技能组合
    protected Command command;

    //升级策略
    private LevelUpStrategy levelUpStrategy;

    //等级状态
    private State state;
    State level2state;
    State level3state;
    State levelhighstate;

    public Role() {
        this.levelUpStrategy = new ConcreteLevelUpStrategy();
        this.level2state = new LevelTwoState(this);
        this.level3state = new LevelThreeState(this);
        this.levelhighstate = new LevelHighState(this);
        this.command = new ConcreteCommand(this);

    }


    public int attackBySkill1() {
        return skill1.getDps() + this.calculateDPS();
    }

    public int attackBySkill2() {
        if (skill2 == null) {
            return 0;
        }
        return skill2.getDps() + this.calculateDPS();
    }

    public int attackBySkill3() {
        if (skill3 == null) {
            return 0;
        }
        return skill3.getDps() + this.calculateDPS();
    }

    public int attackByCommand() {
        return command.execute() + this.calculateDPS();
    }


    /**
     * 计算总攻击力：角色攻击力+武器攻击力
     *
     * @return
     */
    public int calculateDPS() {
        int weaponPower = this.weapon == null ? 0 : this.weapon.getPower();
        return this.attackValue + weaponPower;
    }


    /**
     * 计算总防御值：角色防御值+装备防御值
     *
     * @return
     */
    public int calculateDefense() {
        int equipDefense = 0;
        if (equipmentList.size() > 0) {
            for (Equipment equipment : equipmentList) {
                equipDefense += equipment.calculateDefense();
            }

        }
        return this.defendValue + equipDefense;
    }


    /**
     * 计算总血量：角色血量+装备血量
     *
     * @return
     */
    public int calculateHP() {
        int equipHP = 0;
        if (equipmentList.size() > 0) {
            for (Equipment equipment : equipmentList) {
                equipHP += equipment.calculateHP();
            }

        }
        return this.HP + equipHP;
    }

    public void update(Monster monster) {
        this.setMoney(this.getMoney() + monster.getEarnMoney());
        levelUpStrategy.upgrade(this, monster.getEarnExp());
    }
}
