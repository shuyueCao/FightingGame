package entity.role.factory;

import entity.role.Role;
import entity.role.GuanYu;

/**
 * 角色关羽的具体工厂类
 * @author phoebegl
 * @Date 2019/4/8.
 */
public class GYFactory implements RoleFactory{

    public Role getRole() {
        return new GuanYu();
    }
}
