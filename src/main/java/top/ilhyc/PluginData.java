package top.ilhyc;

import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

public class PluginData {
    public File f;
    public FileConfiguration fc;

    public PluginData(File f){
        this.f = f;
        createit(this.f);
        this.fc = YamlConfiguration.loadConfiguration(f);
        save();
    }

    public PluginData(File f, String name){
        this.f = new File(f,name);
        createit(f);
        this.fc = YamlConfiguration.loadConfiguration(this.f);
        save();
    }

    public PluginData(String s){
        this.f = new File(CustomPray.getData(),s);
        createit(f);
        this.fc = YamlConfiguration.loadConfiguration(this.f);
        save();
    }


    public void save() {
        try {
            this.fc.save(this.f);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Collection<String> getKeys(String path) {
        if (path == null || path.equals("")) {
            return fc.getKeys(false);
        } else {
            return fc.getConfigurationSection(path).getKeys(false);
        }
    }

    public void set(String path, Object object) {
        fc.set(path, object);
    }

    public Object get(String path) {
        return fc.get(path);
    }

    public String getString(String path) {
        return this.fc.getString(path);
    }

    public int getInt(String path) {
        return fc.getInt(path);
    }

    public double getDouble(String path){
        return fc.getDouble(path);
    }

    public List<?> getList(String path){
        return fc.getList(path);
    }

    public List<String> getStringList(String path){
        return fc.getStringList(path);
    }

    public static FileConfiguration getConfig(){
        CustomPray plugin = top.ilhyc.CustomPray.getPlugin(top.ilhyc.CustomPray.class);
        return plugin.getConfig();
    }

    public static List<String> lore(String...list){
        List<String> lores = new ArrayList<>();
        for(String s:list) {
            lores.add(CustomPray.Auto(s));
        }
        return lores;
    }

    public static List<String> lore(List<String> list){
        List<String> lores = new ArrayList<>();
        for(String s:list){
            if(s!=null) {
                lores.add(CustomPray.Auto(s));
            }
        }
        return lores;
    }

    public File getF() {
        return f;
    }

    public FileConfiguration getFc() {
        return fc;
    }

    public void create(){
        if(!this.f.exists()){
            try {
                this.f.createNewFile();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    public static void createit(File f){
        if(!f.exists()){
            try {
                f.createNewFile();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    public File[] getDatas(){
        return this.f.listFiles();
    }

    public List<FileConfiguration> getinDatas(){
        ArrayList<FileConfiguration> afc = new ArrayList<>();
        File[] fs = getDatas();
        for(int i=0;i<fs.length;i++){
            afc.add(YamlConfiguration.loadConfiguration(fs[i]));
        }
        return afc;
    }

    public String deleteYml() {
        if(this.f.getName().contains(".yml")) {
            String newname = "";
            for (int i = 0; i < f.getName().length(); i++) {
                if (i < this.f.getName().length() - 4) {
                    newname = newname + this.f.getName().charAt(i);
                }
            }
            return newname;
        }
        return f.getName();
    }

    public static String deleteYml(File f) {
        if (f.getName().contains(".yml")) {
            String newname = "";
            for (int i = 0; i < f.getName().length(); i++) {
                if (i < f.getName().length() - 4) {
                    newname = newname + f.getName().charAt(i);
                }
            }
            return newname;
        }
        return f.getName();
    }


    public boolean getBoolean(String s){
        return fc.getBoolean(s);
    }

    public HashMap<String,?> getMap(String root,String key) {
        HashMap<String, Object> map = new HashMap<>();
        if (fc.get(root + "." + key) != null) {
            ConfigurationSection cs = fc.getConfigurationSection(root + "." + key);
            for (String s : cs.getKeys(false)) {
                if (s != null) {
                    map.put(s, fc.get(root + "." + key + "." + s));
                }
            }
        }
        return map;
    }
}
