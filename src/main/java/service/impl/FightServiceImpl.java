package service.impl;


import entity.monster.*;
import entity.role.Role;
import service.FightService;

/**
 * created by csy on 2019/4/12
 **/
public class FightServiceImpl implements FightService {

    public static FightServiceImpl instance;

    private FightServiceImpl() {
    }

    public static FightServiceImpl getInstance() {
        if (instance == null) {
            return new FightServiceImpl();
        }
        return instance;
    }


    @Override
    public Monster createMonster(Role role, int times) {
        if(times == 0) {
            return new Bird(role);
        } else if(times == 1) {
            return new Pig(role);
        } else if(times == 2) {
            return new Snake(role);
        } else {
            return new Dragon(role);
        }
    }

    /**
     * 普通攻击
     * @param role
     * @param monster
     * @return
     */
    @Override
    public String attack(Role role, Monster monster) {
        int attackVal = role.calculateDPS();
        return this.roleAttack(role,monster,attackVal);
    }

    @Override
    public String attackBySkill1(Role role, Monster monster) {
        int attackVal = role.attackBySkill1();
        return this.roleAttack(role,monster,attackVal);
    }

    @Override
    public String attackBySkill2(Role role, Monster monster) {
        int attackVal = role.attackBySkill2();
        return this.roleAttack(role,monster,attackVal);
    }

    @Override
    public String attackBySkill3(Role role, Monster monster) {
        int attackVal = role.attackBySkill3();
        return this.roleAttack(role,monster,attackVal);
    }

    @Override
    public String attackByCombination(Role role, Monster monster) {
        int attackVal = role.attackByCommand();
        return this.roleAttack(role,monster,attackVal);
    }

    private String roleAttack(Role role,Monster monster,int attackVal){
        int monsterHP = monster.getHP() - attackVal <= 0 ? 0 : monster.getHP() - attackVal;
        monster.setHP(monsterHP);

        if (monster.getHP() > 0) {
            //怪物攻击回合
            return this.monsterAttack(role, monster, attackVal);
        } else {
            //怪物死亡
            monster.notifyRole();
            return "怪物死亡, 您已获得本局胜利! 获得金钱" +monster.getEarnMoney()+ "元, 获得经验值" +monster.getEarnExp()+ "点";
        }
    }

    private String monsterAttack(Role role,Monster monster, int attackVal) {
        int harm = monster.getAttackValue() - role.calculateDefense() < 0 ? 0 : monster.getAttackValue() - role.calculateDefense();
        role.setCurrentHP(role.getCurrentHP() - harm);

        if (role.getCurrentHP() <= 0) {
            return "对不起, 您已被怪物打败, 本局失败!";
        } else {
            return "本局您对怪物造成了" + attackVal + "点伤害, 怪物对您造成了" + harm + "点伤害";
        }
    }

}
