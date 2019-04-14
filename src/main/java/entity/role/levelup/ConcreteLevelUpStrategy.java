package entity.role.levelup;

import entity.role.Role;
import entity.role.levelstate.LevelHighState;
import entity.role.levelstate.LevelThreeState;

/**
 * @author phoebegl
 * @Date 2019/3/28.
 */
public class ConcreteLevelUpStrategy implements LevelUpStrategy {

    @Override
    public void upgrade(Role role, Integer increExp) {
        role.setExperience(role.getExperience() + increExp);
        //重置当前血量为满值
        role.setCurrentHP(role.getHP());

        //角色属性提升
        while (role.getExperience() >= getNeededExp(role.getLevel())) {
            role.setLevel(role.getLevel() + 1);
            role.setHP(role.getHP() + 10);
            role.setDefendValue(role.getDefendValue() + 5);
            role.setAttackValue(role.getAttackValue() + 5);
            this.skillUpgrade(role);
        }

    }

    /**
     * 技能升级体系
     *
     * @param role
     */
    public void skillUpgrade(Role role) {
        if (role.getLevel() == 2 && role.getSkill2() == null) {//等级达到二级
            role.setState(role.getLevel2state());
            role.getState().unlockSkill();
        } else if (role.getLevel() == 3 && role.getSkill3() == null) {//等级达到三级
            role.setState(role.getLevel3state());
            role.getState().unlockSkill();
        } else if (role.getLevel() == 4 && role.getState().getClass().isInstance(LevelThreeState.class)) {
            role.setState(role.getLevelhighstate());
        } else if (role.getState().getClass().isInstance(LevelHighState.class)){
            if (role.getLevel() % 5 == 0) {//每五级所有技能升一级
                role.notifyObservers();
            }
        }
    }


    /**
     * 返回升级所需经验值,使用斐波那契数列进行计算
     *
     * @param level
     * @return
     */
    private Integer getNeededExp(int level) {
        int base = 100;
        if (level == 1 || level == 2) {
            return base * level;
        }

        int pre = 1;
        int cur = 2;

        for (int i = 2; i < level; i++) {
            int temp = pre + cur;
            pre = cur;
            cur = temp;
        }

        return base * cur;
    }

}
