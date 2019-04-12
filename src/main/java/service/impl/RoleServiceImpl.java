package service.impl;

import entity.role.Role;
import entity.role.factory.DCFactory;
import entity.role.factory.GYFactory;
import entity.role.factory.LBFactory;
import entity.role.factory.RoleFactory;
import service.RoleService;

import java.util.ArrayList;
import java.util.List;

/**
 * @author phoebegl
 * @Date 2019/4/12.
 */
public class RoleServiceImpl implements RoleService {

    private static RoleServiceImpl instance;
    private Role currentRole;

    private RoleServiceImpl() {}

    public static RoleServiceImpl getInstance() {
        if (instance == null) {
            instance = new RoleServiceImpl();
        }
        return instance;
    }

    public List<String> getAllRoles() {
        List<String> res = new ArrayList<String>();
        res.add("貂蝉");
        res.add("关羽");
        res.add("李白");
        return res;
    }

    public void createRole(String type) {
        RoleFactory factory;

        if (type.equals("貂蝉")) {
            factory = new DCFactory();
        } else if (type.equals("关羽")) {
            factory = new GYFactory();
        } else {
            factory = new LBFactory();
        }

        currentRole = factory.getRole();
    }

    public Role getCurrentRole() {
        return currentRole;
    }
}
