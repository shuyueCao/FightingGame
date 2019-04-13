package service;

import entity.role.Role;

import java.util.List;

/**
 * created by csy on 2019/4/12
 **/
public interface ShopService {

    String buyWeapon(Role role,String weaponName,boolean change);

    String buyEquipment(Role role,String equipName);

    String buyGem(Role role,String equipName,String gemName);

    String enhanceWeapon(Role role);

    List<String> getAllWeapons();

    List<String> getAllEquips();

    List<String> getAllGems();

    String getWeaponInfo(String name);

    String getEquipInfo(String name);
}
