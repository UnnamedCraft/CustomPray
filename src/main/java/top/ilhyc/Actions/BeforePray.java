package top.ilhyc.Actions;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import top.ilhyc.CustomPray;
import top.ilhyc.Extra.RandomPrizes;

import java.util.ArrayList;

public class BeforePray {
    public String message;
    public String title;
    public String subtitle;
    public ArrayList<String> commands;
    public String permission;
    public RandomPrizes rp;

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }

    public ArrayList<String> getCommands() {
        return commands;
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

    public void setCommands(ArrayList<String> commands) {
        this.commands = commands;
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

    public void handle(Player p) {
        if (getMessage() != null) {
            p.sendMessage(CustomPray.Auto(getMessage()));
        }
        if (getTitle() != null) {
            String sub = "";
            if (getSubtitle() != null) {
                sub = getSubtitle();
            }
            p.getPlayer().sendTitle(CustomPray.Auto(getTitle()), CustomPray.Auto(sub), 10, 100, 10);
        }
        if (getPermission() != null) {
            if (p.getPlayer().hasPermission(getPermission())) {
                getRp().handle(p);
            }
        } else {
            getRp().handle(p);
        }
    }
}
