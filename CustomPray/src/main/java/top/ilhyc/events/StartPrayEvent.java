package top.ilhyc.events;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.bukkit.event.player.PlayerEvent;
import top.ilhyc.Utils.Pray;

public class StartPrayEvent extends PlayerEvent {
    public Pray pray;
    public Entity ride;
    public static final HandlerList handlerList = new HandlerList();
    public StartPrayEvent(Player who, Entity ride,Pray pray) {
        super(who);
        this.pray = pray;
        this.ride = ride;
    }

    @Override
    public HandlerList getHandlers() {
        return handlerList;
    }

    public static HandlerList getHandlerList() {
        return handlerList;
    }

    public Pray getPray() {
        return pray;
    }

    public void setPray(Pray pray) {
        this.pray = pray;
    }

    public Entity getRide() {
        return ride;
    }

    public void setRide(Entity ride) {
        this.ride = ride;
    }
}
