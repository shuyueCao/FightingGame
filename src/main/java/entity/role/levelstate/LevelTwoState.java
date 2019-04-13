package entity.role.levelstate;


import entity.role.Role;

/**
 * 具体状态类-二级
 * created by csy on 2019/4/10
 **/

public class LevelTwoState implements State{

    private Role role;

    public LevelTwoState(Role role){
        this.role = role;
    }

    public void unlockSkill() {
        role.setSkill2(role.getAbstractSkill2());
        role.addObserver(role.getSkill2());
    }


//    public void upgradeAllSkills() {
//
//    }
}
