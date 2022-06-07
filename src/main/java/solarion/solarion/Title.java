package solarion.solarion;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import solarion.solarion.Db.TitleDb2;

import static solarion.solarion.Solarion.User_List;

public class Title implements Listener {

    public static String color1;
    public static String chat;

    @EventHandler
    public void onChat(AsyncPlayerChatEvent e){
        Player p = e.getPlayer();

        TitleDb2 db_conn = new TitleDb2();
        db_conn.db_PlayerInfo(p);

        color1 = User_List.get(p.getUniqueId().toString()).get_title_color();
        chat = User_List.get(p.getUniqueId().toString()).get_title();

//        if(getValue("칭호",p)==null){
//            addValue("칭호", p,"");
//        }if(getValue("타이틀",p)==null){
//            addValue("타이틀", p,0);
//        }

        if(chat!=null){//(int)getValue("타이틀", p) == 1) {
            if (0 <= p.getLevel() && p.getLevel() <= 50) {
                p.setDisplayName(String.format("%s"+ chat + " " + ChatColor.DARK_GRAY + "[" + p.getLevel() + "] " + ChatColor.WHITE + p.getName(),color1));
            } else if (51 <= p.getLevel() && p.getLevel() <= 100) {
                p.setDisplayName(String.format("%s"+ chat + " " + ChatColor.DARK_PURPLE + "[" + p.getLevel() + "] " + ChatColor.WHITE + p.getName(),color1));
            } else if (101 <= p.getLevel() && p.getLevel() <= 150) {
                p.setDisplayName(String.format("%s"+ chat + " " + ChatColor.DARK_BLUE + "[" + p.getLevel() + "] " + ChatColor.WHITE + p.getName(),color1));
            } else if (151 <= p.getLevel() && p.getLevel() <= 200) {
                p.setDisplayName(String.format("%s"+ chat+ " " + ChatColor.DARK_AQUA + "[" + p.getLevel() + "] " + ChatColor.WHITE + p.getName(),color1));
            } else if (201 <= p.getLevel() && p.getLevel() <= 250) {
                p.setDisplayName(String.format("%s"+ chat + " " + ChatColor.DARK_GREEN + "[" + p.getLevel() + "] " + ChatColor.WHITE + p.getName(),color1));
            } else if (251 <= p.getLevel() && p.getLevel() <= 300) {
                p.setDisplayName(String.format("%s"+ (String) chat + " " + ChatColor.GOLD + "[" + p.getLevel() + "] " + ChatColor.WHITE + p.getName(),color1));
            } else if (301 <= p.getLevel() && p.getLevel() <= 350) {
                p.setDisplayName(String.format("%s"+ (String) chat + " " + ChatColor.DARK_RED + "[" + p.getLevel() + "] " + ChatColor.WHITE + p.getName(),color1));
            } else if (401 <= p.getLevel() && p.getLevel() <= 450) {
                p.setDisplayName(String.format("%s"+ chat + " " + ChatColor.RED + "[" + p.getLevel() + "] " + ChatColor.WHITE + p.getName(),color1));
            } else if (451 <= p.getLevel() && p.getLevel() <= 500) {
                p.setDisplayName(String.format("%s"+ chat + " " + ChatColor.YELLOW + "[" + p.getLevel() + "] " + ChatColor.WHITE + p.getName(),color1));
            } else if (501 <= p.getLevel() && p.getLevel() <= 600) {
                p.setDisplayName(String.format("%s"+chat + " " + ChatColor.GREEN + "[" + p.getLevel() + "] " + ChatColor.WHITE + p.getName(),color1));
            } else if (601 <= p.getLevel() && p.getLevel() <= 700) {
                p.setDisplayName(String.format("%s"+chat + " " + ChatColor.AQUA + "[" + p.getLevel() + "] " + ChatColor.WHITE + p.getName(),color1));
            } else if (701 <= p.getLevel() && p.getLevel() <= 800) {
                p.setDisplayName(String.format("%s"+ chat + " " + ChatColor.BLUE + "[" + p.getLevel() + "] " + ChatColor.WHITE + p.getName(),color1));
            } else if (801 <= p.getLevel() && p.getLevel() <= 900) {
                p.setDisplayName(String.format("%s"+ chat + " " + ChatColor.LIGHT_PURPLE + "[" + p.getLevel() + "] " + ChatColor.WHITE + p.getName(),color1));
            } else if (901 <= p.getLevel() && p.getLevel() <= 999) {
                p.setDisplayName(String.format("%s"+chat + " " + ChatColor.WHITE + "[" + p.getLevel() + "] " + ChatColor.WHITE + p.getName(),color1));
            } else if (p.getLevel() == 1000) {
                p.setDisplayName(String.format("%s"+ chat + " " + ChatColor.WHITE + "[" + "§k" + p.getLevel() + "§f" + "] " + ChatColor.WHITE + "§n" + ChatColor.GOLD + "§l" + p.getName() + ChatColor.WHITE,color1));
            }
        }else {
            if (0 <= p.getLevel() && p.getLevel() <= 50) {
                p.setDisplayName(ChatColor.DARK_GRAY + "[" + p.getLevel() + "] " + ChatColor.WHITE + p.getName());
            } else if (51 <= p.getLevel() && p.getLevel() <= 100) {
                p.setDisplayName(ChatColor.DARK_PURPLE + "[" + p.getLevel() + "] " + ChatColor.WHITE + p.getName());
            } else if (101 <= p.getLevel() && p.getLevel() <= 150) {
                p.setDisplayName(ChatColor.DARK_BLUE + "[" + p.getLevel() + "] " + ChatColor.WHITE + p.getName());
            } else if (151 <= p.getLevel() && p.getLevel() <= 200) {
                p.setDisplayName(ChatColor.DARK_AQUA + "[" + p.getLevel() + "] " + ChatColor.WHITE + p.getName());
            } else if (201 <= p.getLevel() && p.getLevel() <= 250) {
                p.setDisplayName(ChatColor.DARK_GREEN + "[" + p.getLevel() + "] " + ChatColor.WHITE + p.getName());
            } else if (251 <= p.getLevel() && p.getLevel() <= 300) {
                p.setDisplayName(ChatColor.GOLD + "[" + p.getLevel() + "] " + ChatColor.WHITE + p.getName());
            } else if (301 <= p.getLevel() && p.getLevel() <= 350) {
                p.setDisplayName(ChatColor.DARK_RED + "[" + p.getLevel() + "] " + ChatColor.WHITE + p.getName());
            } else if (401 <= p.getLevel() && p.getLevel() <= 450) {
                p.setDisplayName(ChatColor.RED + "[" + p.getLevel() + "] " + ChatColor.WHITE + p.getName());
            } else if (451 <= p.getLevel() && p.getLevel() <= 500) {
                p.setDisplayName(ChatColor.YELLOW + "[" + p.getLevel() + "] " + ChatColor.WHITE + p.getName());
            } else if (501 <= p.getLevel() && p.getLevel() <= 600) {
                p.setDisplayName( ChatColor.GREEN + "[" + p.getLevel() + "] " + ChatColor.WHITE + p.getName());
            } else if (601 <= p.getLevel() && p.getLevel() <= 700) {
                p.setDisplayName(ChatColor.AQUA + "[" + p.getLevel() + "] " + ChatColor.WHITE + p.getName());
            } else if (701 <= p.getLevel() && p.getLevel() <= 800) {
                p.setDisplayName(ChatColor.BLUE + "[" + p.getLevel() + "] " + ChatColor.WHITE + p.getName());
            } else if (801 <= p.getLevel() && p.getLevel() <= 900) {
                p.setDisplayName(ChatColor.LIGHT_PURPLE + "[" + p.getLevel() + "] " + ChatColor.WHITE + p.getName());
            } else if (901 <= p.getLevel() && p.getLevel() <= 999) {
                p.setDisplayName(ChatColor.WHITE + "[" + p.getLevel() + "] " + ChatColor.WHITE + p.getName());
            } else if (p.getLevel() == 1000) {
                p.setDisplayName(ChatColor.WHITE + "[" + "§k" + p.getLevel() + "§f" + "] " + ChatColor.WHITE + "§n" + ChatColor.GOLD + "§l" + p.getName() + ChatColor.WHITE);
            }
        }






    }
}