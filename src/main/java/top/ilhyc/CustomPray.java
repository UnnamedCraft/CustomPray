package top.ilhyc;

import com.sun.javafx.binding.StringFormatter;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerChatTabCompleteEvent;
import org.bukkit.plugin.java.JavaPlugin;
import top.ilhyc.Utils.Pray;
import top.ilhyc.commands.MainCommands;
import top.ilhyc.events.MainListener;

import java.io.File;
import java.util.HashMap;

public final class CustomPray extends JavaPlugin {
    public static File data;
    public static File prayers;
    public static File randomprizes;
    public static HashMap<String, Pray> map = new HashMap<>();
    @Override
    public void onEnable() {
        // Plugin startup logic
        getConfig().options().copyDefaults();
        System.out.println("[CustomPray]插件已启动");
        data = getDataFolder();
        if(!data.exists()){
            try {
                data.mkdirs();
            }catch (Exception e){
                e.printStackTrace();
            }
            saveDefaultConfig();
        }
        getServer().getPluginCommand("pray").setExecutor(new MainCommands());
        getServer().getPluginManager().registerEvents(new MainListener(),this);
        loadData();
    }
    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static void loadData(){
        map.clear();
        prayers = new File(data,"Prayers");
        randomprizes = new File(data,"RandomPrizes");
        if(!prayers.exists()){  //创建prayers
            try {
                prayers.mkdirs();
            }catch (Exception e){
                e.printStackTrace();
            }
        }

        if(!randomprizes.exists()){  //创建randomprizes
            try{
                randomprizes.mkdirs();
            }catch (Exception e){
                e.printStackTrace();
            }
        }

        if(prayers.listFiles()!=null){
            for(File f:prayers.listFiles()) {
                map.put(PluginData.deleteYml(f),new Pray(PluginData.deleteYml(f)));
            }
        }

        Bukkit.getLogger().info(Auto("&e当前服务器已载入&c"+map.values().size()+"&e个祈愿项目!"));
    }

    public static String Auto(String s){
        return ChatColor.translateAlternateColorCodes('&',s);
    }

    public static File getData() {
        return data;
    }

    public static File getPrayers() {
        return prayers;
    }

    public static File getRandomprizes() {
        return randomprizes;
    }

    public static HashMap<String, Pray> getMap() {
        return map;
    }

    public static CustomPray getMain(){
        return getPlugin(top.ilhyc.CustomPray.class);
    }

    public static String replacePlayer(String s, Player p){
        if(s.contains("%player%")) {
            s.replace("%player%", p.getName());
            return s;
        }else{
            return "";
        }
    }
}
