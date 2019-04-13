package entity.role.levelstate;

import entity.role.Role;

/**
 * created by csy on 2019/4/13
 **/
public class LevelHighState implements State {

    private Role role;

    public LevelHighState(Role role){
        this.role = role;
    }

    public void unlockSkill() {

    }

}
