package com.example.fightinggame.bean.role;

import com.example.fightinggame.bean.Role;

/**
 * 具体的角色实现类——李白
 * @author phoebegl
 * @Date 2019/3/25.
 */
public class LiBai extends Role {

    public LiBai() {
        this.attackValue = 120;
        this.defendValue = 80;
        this.hp = 100;
        this.experience = 0;
        this.money = 500;
    }
}
