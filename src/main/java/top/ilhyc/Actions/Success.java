package top.ilhyc.Actions;

import org.bukkit.Particle;
import top.ilhyc.CustomPray;
import top.ilhyc.Extra.RandomPrizes;
import top.ilhyc.PluginData;

import java.util.ArrayList;

public class Success {
    public String message;
    public String title;
    public String subtitle;
    public String permission;
    public RandomPrizes rp;

    public void setTitle(String title) {
        this.title = title;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public void setRp(RandomPrizes rp) {
        this.rp = rp;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTitle() {
        return title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public String getMessage() {
        return message;
    }

    public RandomPrizes getRp() {
        return rp;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public static Success getSuccess(String s){
        PluginData pd = new PluginData(CustomPray.getPrayers(),s+".yml");
        Success sc = new Success();
        sc.setMessage(pd.getString("success.message"));
        sc.setPermission(pd.getString("success.hypothesis.permission"));
        sc.setRp(RandomPrizes.getRandomPrizes(pd.getString("success.hypothesis.randomprize")));
        sc.setSubtitle(pd.getString("success.subtitle"));
        sc.setTitle(pd.getString("success.title"));
        return sc;
    }
}
