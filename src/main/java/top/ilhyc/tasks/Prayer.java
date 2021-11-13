package top.ilhyc.tasks;

import net.md_5.bungee.api.ChatMessageType;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import top.ilhyc.Actions.Success;
import top.ilhyc.CustomPray;
import top.ilhyc.Extra.RandomPrizes;
import top.ilhyc.Utils.Pray;
import top.ilhyc.events.PrayFailEvent;
import top.ilhyc.events.PraySucceedEvent;

import java.util.Random;

public class Prayer extends BukkitRunnable {
    Player p;
    Pray pray;
    Entity ride;
    long last = System.currentTimeMillis();
    @Override
    public void run() {
        for(int i =0;i<=36;i++){
            p.getWorld().spawnParticle(Particle.CAMPFIRE_COSY_SMOKE,getCircleAngle(i,p.getLocation(),5),1,0,0,0,0);
        }
        if(this.last+pray.getLast()* 1000L <System.currentTimeMillis()){
            Random r = new Random();
            r.setSeed(System.currentTimeMillis());
            if(r.nextInt(10000)<=pray.getOdd()){
                CustomPray.getMain().getServer().getPluginManager().callEvent(new PraySucceedEvent(this.p,this.pray));
            }else{
                CustomPray.getMain().getServer().getPluginManager().callEvent(new PrayFailEvent(this.p,this.pray));
            }
            p.getWorld().playSound(p.getLocation(), Sound.AMBIENT_UNDERWATER_ENTER,1,1);
            ride.remove();
            this.cancel();
        }
    }

    public Prayer(Player p, Pray pray,Entity ride){
        this.p = p;
        this.pray = pray;
        this.ride = ride;
    }

    public static Location getCircleAngle(int i, Location l, int radius){
        Location location = l.clone();
        location.setX(location.getX()+Math.sin(Math.PI/18*i)*radius);
        location.setZ(location.getZ()+Math.cos(Math.PI/18*i)*radius);
        return location;
    }
}
