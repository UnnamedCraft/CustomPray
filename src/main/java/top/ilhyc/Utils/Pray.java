package top.ilhyc.Utils;

import net.md_5.bungee.api.ChatMessageType;
import org.bukkit.ChatColor;
import top.ilhyc.Actions.BeforePray;
import top.ilhyc.Actions.Fault;
import top.ilhyc.Actions.Success;
import top.ilhyc.CustomPray;
import top.ilhyc.Extra.Prize;
import top.ilhyc.Extra.RandomPrizes;
import top.ilhyc.PluginData;

public class Pray {
    public String internalname;
    public String showedname;
    public int delay = 0;
    public PrayRequire pr = new PrayRequire();
    public int last = 0;
    public BeforePray beforePray;
    public Success sc;
    public Fault fl;
    public int odd;
    public Pray(String primitive){
        this.internalname = primitive;
    }

    public static Pray getPrayer(String primitive){
        Pray pray = new Pray(primitive);
        PluginData pd = new PluginData(CustomPray.getPrayers(),primitive+".yml");
        pray.setDelay(pd.getInt("delay"));
        pray.setShowedname(pd.getString("name"));
        PrayRequire pr = new PrayRequire();
        pr.setCoins(pd.getDouble("require.coins"));
        pr.setPermission(pd.getString("require.permission"));
        pray.setPr(pr);
        pray.setLast(pd.getInt("last"));
        BeforePray bp = new BeforePray();
        bp.setMessage(pd.getString("beforepray.message"));
        bp.setPermission(pd.getString("beforepray.hypothesis.permission"));
        bp.setTitle(pd.getString("beforepray.title"));
        bp.setSubtitle(pd.getString("beforepray.subtitle"));
        RandomPrizes rp = RandomPrizes.getRandomPrizes(pd.getString("beforepray.hypothesis.randomprize"));
        //此处缺少随机奖励的配置
        bp.setRp(rp);
        pray.setBeforePray(bp);
        pray.setFl(Fault.getFault(primitive));
        pray.setSc(Success.getSuccess(primitive));
        return pray;
    }

    public PrayRequire getPr() {
        return pr;
    }

    public int getDelay() {
        return delay;
    }

    public String getShowedname() {
        return showedname;
    }

    public void setPr(PrayRequire pr) {
        this.pr = pr;
    }

    public void setDelay(int delay) {
        this.delay = delay;
    }

    public void setShowedname(String showedname) {
        this.showedname = showedname;
    }

    public String getInternalname() {
        return internalname;
    }

    public int getLast() {
        return last;
    }

    public void setLast(int last) {
        this.last = last;
    }

    public BeforePray getBeforePray() {
        return beforePray;
    }

    public void setBeforePray(BeforePray beforePray) {
        this.beforePray = beforePray;
    }

    public Fault getFl() {
        return fl;
    }

    public Success getSc() {
        return sc;
    }

    public void setFl(Fault fl) {
        this.fl = fl;
    }

    public void setSc(Success sc) {
        this.sc = sc;
    }

    public void setOdd(int odd) {
        this.odd = odd;
    }

    public int getOdd() {
        return odd;
    }
}
