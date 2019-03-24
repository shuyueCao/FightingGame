package com.example.fightinggame.entity;

import lombok.Data;

/**
 * created by csy on 2019/3/23
 **/

@Data
public class Player {

    private volatile static Player player;

    private static final String name = "";
    private static int HP = 100;
    private static int currentHP = 100;
    private static int level = 0;
    private static int exp = 0;
    private static int attack = 10;
    private static Skill skill1;
    private static Skill skill2;
    private static Skill skill3;
    private static Weapon weapon;

    private Player() {
    }


    public static Player getPlayer() {
        if (player == null) {
            synchronized (Player.class) {
                if (player == null) {
                    player = new Player();
                }
            }
        }
        return player;
    }


}
