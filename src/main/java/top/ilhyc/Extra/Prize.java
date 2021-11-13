package top.ilhyc.Extra;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Prize {
    public int odd;
    public List<String> commands;

    public void setCommands(List<String> commands) {
        this.commands = commands;
    }

    public List<String> getCommands() {
        return commands;
    }

    public List<String> addCommand(String ...command){
        commands.addAll(Arrays.asList(command));
        return commands;
    }

    public int getOdd() {
        return odd;
    }

    public void setOdd(int odd) {
        this.odd = odd;
    }
}
