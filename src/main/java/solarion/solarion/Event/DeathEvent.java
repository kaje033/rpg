package solarion.solarion.Event;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import solarion.solarion.Exp.Exp;

import java.security.SecureRandom;

public class DeathEvent implements Listener {

    SecureRandom rand = new SecureRandom();

    @EventHandler
    public void onDeath(PlayerDeathEvent e){
        Player p = e.getEntity();

        if(p.getLevel()<10){

            p.sendMessage(ChatColor.RED+"레벨이 낮아 경헙치를 잃지 않았습니다!");
        }else{
            if(rand.nextInt(100) <=50){

                int exp = (int)(Exp.getPlayerExp(p)*0.1);


                p.sendMessage(String.valueOf(Exp.getPlayerExp(p)));
                p.setTotalExperience(exp);

                p.sendMessage(ChatColor.RED+"죽음으로 인해 경험치를 잃었습니다!");
            }else{
                p.sendMessage(ChatColor.RED+"경험치를 잃지 않았습니다");
            }
        }
    }


}
