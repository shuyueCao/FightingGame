package entity.role.factory;

import entity.role.Role;
import entity.role.LiBai;

/**
 * 角色李白的具体工厂类
 * @author phoebegl
 * @Date 2019/4/8.
 */
public class LBFactory implements RoleFactory{

    public Role getRole() {
        return new LiBai();
    }
}
