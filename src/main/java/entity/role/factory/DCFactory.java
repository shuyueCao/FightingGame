package entity.role.factory;

import entity.role.Role;
import entity.role.DiaoChan;

/**
 * 角色貂蝉的具体工厂类
 * @author phoebegl
 * @Date 2019/4/8.
 */
public class DCFactory implements RoleFactory{

    public Role getRole() {
        return new DiaoChan();
    }
}
