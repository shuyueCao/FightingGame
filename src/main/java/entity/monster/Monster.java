/**
 * @author:RickeyJiang
 * @date:2019年3月4日
 */
package entity.monster;

import lombok.Data;

@Data
public abstract class Monster {
	protected String name;
	protected Integer attackValue;
	protected Integer HP;
	protected Integer earnExp;
	protected Integer earnMoney;


}
