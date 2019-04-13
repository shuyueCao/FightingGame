package service.impl;


import entity.monster.Monster;
import entity.role.Role;
import service.FightService;

/**
 * created by csy on 2019/4/12
 **/
public class FightServiceImpl implements FightService {

    public static FightServiceImpl instance;

    public FightServiceImpl() {
    }

    public static FightServiceImpl getInstance() {
        if (instance == null) {
            return new FightServiceImpl();
        }
        return instance;
    }


    /**
     * 普通攻击
     * @param role
     * @param monster
     * @return
     */
    public Role attack(Role role, Monster monster) {
        int attackVal = role.getAttackValue();
        role = this.roleAttack(role,monster,attackVal);
        return role;
    }

    public Role attackBySkill1(Role role, Monster monster) {
        int attackVal = role.attackBySkill1();
        role = this.roleAttack(role,monster,attackVal);
        return role;
    }

    public Role attackBySkill2(Role role, Monster monster) {
        int attackVal = role.attackBySkill2();
        role = this.roleAttack(role,monster,attackVal);
        return role;
    }

    public Role attackBySkill3(Role role, Monster monster) {
        int attackVal = role.attackBySkill3();
        role = this.roleAttack(role,monster,attackVal);
        return role;
    }

    public Role attackByCombination(Role role, Monster monster) {
        int attackVal = role.attackByCommand();
        role = this.roleAttack(role,monster,attackVal);
        return role;
    }

    public Role monsterAttack(Role role, Monster monster) {
        int attackVal = monster.getAttackValue() - role.calculateDefense() < 0 ? 0 : monster.getAttackValue() - role.calculateDefense();
        role.setCurrentHP(role.getCurrentHP() - attackVal);
        return role;
    }

    private Role roleAttack(Role role,Monster monster,int attackVal){
        int monsterHP = monster.getHP() - attackVal <= 0 ? 0 : monster.getHP() - attackVal;
        monster.setHP(monsterHP);
        if (monster.getHP() > 0) {//怪物攻击回合
            role = this.monsterAttack(role, monster);
        } else {//怪物死亡
            role.setMoney(role.getMoney() + monster.getEarnMoney());
            role.getLevelUpStrategy().upgrade(role,monster.getEarnExp());
        }
        return role;
    }

}
