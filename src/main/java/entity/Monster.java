package entity;

import lombok.Data;

/**
 * @author phoebegl
 * @Date 2019/3/28.
 */
@Deprecated
@Data
public abstract class Monster {

    protected String name;
    protected Integer defendValue;
    protected Integer attackValue;
    protected Integer HP;
    protected Integer winMoney;
    protected Integer winExp;
}
