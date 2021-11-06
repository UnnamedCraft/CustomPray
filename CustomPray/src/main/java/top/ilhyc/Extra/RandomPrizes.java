package top.ilhyc.Extra;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import top.ilhyc.CustomPray;
import top.ilhyc.PluginData;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomPrizes {
    public List<Prize> pl = new ArrayList<>();

    public static RandomPrizes getRandomPrizes(String s){
        PluginData pd = new PluginData(CustomPray.getRandomprizes(),s+".yml");
        RandomPrizes rp = new RandomPrizes();
            for (String key : pd.getFc().getKeys(false)) {
                Prize prize = new Prize();
                prize.setOdd(pd.getInt(key + ".odd"));
                prize.setCommands(pd.getStringList(key + ".commands"));
                rp.pl.add(prize);
            }
        return rp;
    }

    public void handle(Player p){
        pl.get(countOdd(pl)).getCommands().stream().forEach(a->Bukkit.dispatchCommand(Bukkit.getConsoleSender(),CustomPray.replacePlayer(a,p)));
    }

    public static int countOdd(List<Prize> lp){
        int odds =0;
        for(Prize prize:lp) {
            odds = odds + prize.getOdd();
        }
        Random r = new Random(System.currentTimeMillis());
        int odd = r.nextInt(odds);
        int i = 0;
        for(Prize p:lp){
            if(odd>p.getOdd()){
                odd = odd-p.getOdd();
                i++;
            }else{
                return i;
            }
        }
        return 0;
    }
}
