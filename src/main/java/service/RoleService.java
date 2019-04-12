package service;

import entity.role.Role;

import java.util.List;

/**
 * @author phoebegl
 * @Date 2019/4/12.
 */
public interface RoleService {

    List<String> getAllRoles();

    void createRole(String type);

    Role getCurrentRole();
}

