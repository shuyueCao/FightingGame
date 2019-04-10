package entity.role.levelstate;

import entity.Role;

/**
 * created by csy on 2019/4/10
 **/
public class LevelThreeState implements State {

    private Role role;

    public LevelThreeState(Role role){
        this.role = role;
    }

    public void unlockSkill2() {

    }

    public void unlockSkill3() {
        role.setSkill3(role.getAbstractSkill3());
        role.addObserver(role.getSkill3());
    }

//    public void upgradeAllSkills() {
//
//    }
}
