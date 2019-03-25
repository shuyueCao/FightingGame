package com.example.fightinggame.bean.role;

import com.example.fightinggame.bean.Role;

/**
 * 具体的角色实现类——韩信
 * @author phoebegl
 * @Date 2019/3/25.
 */
public class HanXin extends Role {

    public HanXin() {
        this.attackValue = 100;
        this.defendValue = 100;
        this.hp = 100;
        this.experience = 0;
        this.money = 500;
    }
}
