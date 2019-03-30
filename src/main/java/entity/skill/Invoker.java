package entity.skill;

import java.util.Comparator;

/**
 * created by csy on 2019/3/30
 **/
public class Invoker {

    private Command command;

    public Invoker(Command command){
        this.command = command;
    }

    public int action(){
        return command.execute();
    }
}
