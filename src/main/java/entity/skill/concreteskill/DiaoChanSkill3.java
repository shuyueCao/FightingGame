package entity.skill.concreteskill;

import entity.role.DiaoChan;
import entity.skill.AbstractSkill3;
import javafx.scene.chart.PieChart;
import lombok.Data;

import java.util.Observable;

/**
 * created by csy on 2019/3/30
 **/
@Data
public class DiaoChanSkill3 extends AbstractSkill3 {

    public DiaoChanSkill3() {
        this.level = 1;
        this.name = "绽风华";
        this.description = "貂蝉绽放风华在原地结成法阵，法阵生成及消失时都将造成伤害";
        this.dps = 10;
    }

    public void update(Observable o, Object arg) {
        this.level++;
        this.dps += 10;
    }
}
