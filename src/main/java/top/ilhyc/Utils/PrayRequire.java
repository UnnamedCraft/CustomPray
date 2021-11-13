package top.ilhyc.Utils;

import java.util.Objects;

public class PrayRequire{
    public double coins=0;
    public String permission;

    public double getCoins() {
        return coins;
    }

    public String getPermission() {
        return permission;
    }

    public void setCoins(double coins) {
        this.coins = coins;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PrayRequire that = (PrayRequire) o;
        return Double.compare(that.getCoins(), this.coins) == 0 && Objects.equals(permission, that.getPermission());
    }

    @Override
    public int hashCode() {
        return Objects.hash(coins, permission);
    }
}
