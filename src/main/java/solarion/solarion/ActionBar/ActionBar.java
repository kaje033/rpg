package solarion.solarion.ActionBar;


import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import solarion.solarion.Exp.Exp;
import solarion.solarion.Hash;


public class ActionBar implements Listener {
    public ActionBar(){
    }







    @EventHandler
    public void onMove(PlayerMoveEvent e){
        Player p = e.getPlayer();
        if(Hash.getValue("마나",p)==null){
            Hash.addValue("마나",p,100);
        }if(Hash.getValue("기본마나",p)==null){
            Hash.addValue("기본마나",p,100);
        }if(Hash.getValue("최대체력",p)==null) {
            Hash.addValue("최대체력",p,20);
        }


        p.spigot().sendMessage(ChatMessageType.ACTION_BAR,new TextComponent(ChatColor.GOLD+"Health: "+ChatColor.RED+Math.floor((p.getHealth()*100)/100)+"/"+p.getMaxHealth()+" "+ChatColor.BLUE+"Mana"+": "+ Hash.getValue("마나",p)+"/"+Hash.getValue("기본마나",p)+" "+ChatColor.GREEN+"Level: "+p.getLevel()+" "+"EXP: "+(Exp.getPlayerExp(p)- Exp.getExpAtLevel(p.getLevel()))+"/"+ p.getExpToLevel()));
    }

//    public ActionBar(Main plugin){
//        this.plugin = plugin;
//    }
//    public static Main plugin;

//    public static void action() {
//        new BukkitRunnable() {
//            @Override
//            public void run() {
//                p.spigot().sendMessage(ChatMessageType.ACTION_BAR,new TextComponent(ChatColor.GOLD+"Health: "+ChatColor.RED+Math.floor((p.getHealth()*100)/100)+"/"+p.getMaxHealth()+" : "+ChatColor.BLUE+"Mana"+": "+ Hash.getValue("마나",p)+"/"+Hash.getValue("기본마나",p)+" : "+ChatColor.GREEN+"Level: "+p.getLevel()+" : "+"EXP: "+(Exp.getPlayerExp(p)-Exp.getExpAtLevel(p.getLevel()))+"/"+ p.getExpToLevel()));
//            }
//        }.runTaskTimer(plugin, 0L, 1L);
//    }
}
