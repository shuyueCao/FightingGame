package com.example.fightinggame.bean.role;

import com.example.fightinggame.bean.Role;

/**
 * 具体的角色实现类——小乔
 * @author phoebegl
 * @Date 2019/3/25.
 */
public class XiaoQiao extends Role {

    public XiaoQiao() {
        this.attackValue = 80;
        this.defendValue = 120;
        this.hp = 100;
        this.experience = 0;
        this.money = 500;
    }
}
