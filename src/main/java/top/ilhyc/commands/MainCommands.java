package top.ilhyc.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.AreaEffectCloud;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import top.ilhyc.CustomPray;
import top.ilhyc.Utils.Pray;
import top.ilhyc.events.StartPrayEvent;

public class MainCommands implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player){
            Player p = (Player)sender;
            if(args.length>0){
                if(args[0].equalsIgnoreCase("help")){
                    p.sendMessage(CustomPray.Auto("&7功能尚未完成"));
                }else if(args[0].equalsIgnoreCase("reload")){
                    CustomPray.loadData();
                    p.sendMessage(CustomPray.Auto("&a插件已重载!"));
                }else{
                    if(CustomPray.getMap().get(args[0])!=null) {
                        Entity entity = p.getWorld().spawnEntity(p.getLocation(), EntityType.AREA_EFFECT_CLOUD);
                        entity.setSilent(true);
                        AreaEffectCloud aec = (AreaEffectCloud) entity;
                        aec.setRadius(1);
                        aec.setWaitTime(1000000);
                        aec.setGravity(false);
                        entity.addPassenger(p);
                        StartPrayEvent sp = new StartPrayEvent(p, entity, Pray.getPrayer(args[0]));
                        CustomPray.getMain().getServer().getPluginManager().callEvent(sp);
                    }else{
                        p.sendMessage(CustomPray.Auto("&c暂时未有此祈愿内容"));
                    }
                }
            }else{
            }
        }
        return false;
    }
}
