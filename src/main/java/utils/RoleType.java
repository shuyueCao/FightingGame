package utils;

/**
 * @author phoebegl
 * @Date 2018/12/3.
 */
public enum RoleType {

    UNDO("未做题", 1),
    /**
     * ongoing
     */
    ONGOING("做题中", 2),
    /**
     * suspend
     */
    SUSPEND("已暂停", 3),
    /**
     * submit
     */
    SUBMIT("已交卷", 4),
    /**
     * remarking
     */
    REMARKING("待批阅", 5),
    /**
     * remarked
     */
    REMARKED("已批阅", 6),

    /**
     * quit
     */
    QUIT("已退出", 7);

    private String name;
    private int value;

    RoleType(String name, int value) {
        this.name = name;
        this.value = value;
    }

    public static String getName(int value) {
        for (RoleType p : RoleType.values()) {
            if(p.value == value) {
                return p.name;
            }
        }
        return null;
    }

    public String getName() {
        return name;
    }

    public static int getValue(String name) {
        for (RoleType p : RoleType.values()) {
            if(p.name.equals(name)) {
                return p.value;
            }
        }
        return -1;
    }

    public int getValue() {
        return value;
    }

}
