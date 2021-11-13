package top.ilhyc.Actions;

import top.ilhyc.CustomPray;
import top.ilhyc.Extra.RandomPrizes;
import top.ilhyc.PluginData;

import java.io.File;
import java.util.ArrayList;

public class Fault {
    public String message;
    public String title;
    public String subtitle;
    public String permission;
    public RandomPrizes rp;

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public RandomPrizes getRp() {
        return rp;
    }

    public String getMessage() {
        return message;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public String getTitle() {
        return title;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setRp(RandomPrizes rp) {
        this.rp = rp;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public static Fault getFault(String s){
        PluginData pd = new PluginData(CustomPray.getPrayers(),s+".yml");
        Fault fault = new Fault();
        fault.setMessage(pd.getString("fault.message"));
        fault.setPermission(pd.getString("fault.hypothesis.permission"));
        fault.setRp(RandomPrizes.getRandomPrizes(pd.getString("fault.hypothesis.randomprize")));
        fault.setSubtitle(pd.getString("fault.subtitle"));
        fault.setTitle(pd.getString("fault.title"));
        return fault;
    }
}
