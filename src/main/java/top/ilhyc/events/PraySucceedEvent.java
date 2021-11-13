package top.ilhyc.events;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.bukkit.event.player.PlayerEvent;
import top.ilhyc.Utils.Pray;

public class PraySucceedEvent extends PlayerEvent {
    public static final HandlerList handlerList = new HandlerList();
    public Pray pray;
    public PraySucceedEvent(Player who, Pray pray) {
        super(who);
        this.pray = pray;
    }

    @Override
    public HandlerList getHandlers() {
        return handlerList;
    }

    public static HandlerList getHandlerList(){
        return handlerList;
    }

    public Pray getPray() {
        return pray;
    }

    public void setPray(Pray pray) {
        this.pray = pray;
    }
}
