package entity.role.levelup;

import entity.role.Role;

/**
 * @author phoebegl
 * @Date 2019/3/28.
 */
public class ConcreteLevelUpStrategy implements LevelUpStrategy {

    public void upgrade(Role role, Integer increExp) {
        role.setExperience(role.getExperience()+increExp);

        while (role.getExperience() >= getNeededExp(role.getLevel())) {
            role.setLevel(role.getLevel()+1);
        }
    }


    /**
     * 返回升级所需经验值,使用斐波那契数列进行计算
     * @param level
     * @return
     */
    private Integer getNeededExp(int level){
        int base = 100;
        if (level == 1 || level == 2) {
            return base * level;
        }

        int pre = 1;
        int cur = 2;

        for(int i=2;i<level;i++){
            int temp = pre + cur;
            pre = cur;
            cur = temp;
        }

        return base * cur;
    }

}
