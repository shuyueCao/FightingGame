package factory;

import entity.Role;
import entity.role.DiaoChan;
import entity.role.GuanYu;
import entity.role.LiBai;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author phoebegl
 * @Date 2019/3/30.
 */
public class RoleFactory {

    private static Role roleInstance;

    private static Map<String, Class> roleMap;

    static {
        roleMap = new HashMap<String, Class>();
        roleMap.put("貂蝉", DiaoChan.class);
        roleMap.put("关羽", GuanYu.class);
        roleMap.put("李白", LiBai.class);
    }

    public static Set<String> getAllRoles() {
        return roleMap.keySet();
    }

    public static Role getRole(String type) {

        if (roleInstance == null) {
            Class cls = roleMap.get(type);
            System.out.println(cls.getName());
            try {
                roleInstance = (Role) cls.newInstance();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return roleInstance;
    }

}
