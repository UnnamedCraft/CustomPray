package top.ilhyc.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChatTabCompleteEvent;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;
import top.ilhyc.CustomPray;
import top.ilhyc.tasks.Prayer;

public class MainListener implements Listener {
    @EventHandler
    public void prayBeginning(StartPrayEvent e){
        e.getPray().getBeforePray().handle(e.getPlayer());
        BukkitTask bt = new Prayer(e.getPlayer(),e.getPray(),e.getRide()).runTaskTimer(CustomPray.getMain(),e.getPray().getDelay()* 20L,0);
    }

    @EventHandler
    public void prayFail(PrayFailEvent e){
        if(e.getPray().getFl().getMessage()!=null){
            e.getPlayer().sendMessage(CustomPray.Auto(e.getPray().getFl().getMessage()));
        }
        if(e.getPray().getFl().getTitle()!=null){
            String sub = "";
            if(e.getPray().getFl().getSubtitle()!=null){
                sub = e.getPray().getFl().getSubtitle();
            }
            e.getPlayer().sendTitle(CustomPray.Auto(e.getPray().getFl().getTitle()),CustomPray.Auto(sub),10,100,10);
        }
        if(e.getPray().getFl().getPermission()!=null) {
            if (e.getPlayer().hasPermission(e.getPray().getFl().getPermission())) {
                e.getPray().getFl().getRp().handle(e.getPlayer());
            }
        }else{
            e.getPray().getFl().getRp().handle(e.getPlayer());
        }
    }

    @EventHandler
    public void praySuccess(PraySucceedEvent e){
        if(e.getPray().getSc().getMessage()!=null){
            e.getPlayer().sendMessage(CustomPray.Auto(e.getPray().getSc().getMessage()));
        }
        if(e.getPray().getSc().getTitle()!=null){
            String sub = "";
            if(e.getPray().getSc().getSubtitle()!=null){
                sub = e.getPray().getSc().getSubtitle();
            }
            e.getPlayer().getPlayer().sendTitle(CustomPray.Auto(e.getPray().getSc().getTitle()),CustomPray.Auto(sub),10,100,10);
        }
        if(e.getPray().getSc().getPermission()!=null) {
            if (e.getPlayer().hasPermission(e.getPray().getSc().getPermission())) {
                e.getPray().getSc().getRp().handle(e.getPlayer());
            }
        }else{
            e.getPray().getSc().getRp().handle(e.getPlayer());
        }
    }
}
