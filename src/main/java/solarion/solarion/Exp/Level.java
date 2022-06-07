package solarion.solarion.Exp;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLevelChangeEvent;

import static solarion.solarion.Hash.addValue;
import static solarion.solarion.Hash.getValue;

public class Level implements Listener {

    @EventHandler
    public void level(PlayerLevelChangeEvent e) {
        Player p = e.getPlayer();


        if (getValue("스탯포인트", p) == null) {
            addValue("스탯포인트", p, 0);
        }
        if (getValue("민첩", p) == null) {
            addValue("민첩", p, 0);
        }
        if (getValue("힘", p) == null) {
            addValue("힘", p, 0);
        }
        if (getValue("체력", p) == null) {
            addValue("체력", p, 0);
        }
        if (getValue("재주", p) == null) {
            addValue("재주", p, 0);
        }
        if (getValue("지능", p) == null) {
            addValue("지능", p, 0);
        }

        if (p.getLevel() >= 1000) {
            p.sendMessage("최대 레벨을 달성했습니다!");
            p.setLevel(1000);
            p.setExp(0);
            addValue("스탯포인트", p, p.getLevel()-(int) getValue("민첩", p) -(int) getValue("힘", p) - (int) getValue("체력", p) - (int) getValue("재주", p) - (int) getValue("지능", p));

            p.sendMessage("레벨이 " + ChatColor.GREEN + p.getLevel() + ChatColor.WHITE + "이 되었습니다!");
        }else{
            addValue("스탯포인트", p, p.getLevel()-(int) getValue("민첩", p) -(int) getValue("힘", p) - (int) getValue("체력", p) - (int) getValue("재주", p) - (int) getValue("지능", p));

            p.sendMessage("레벨이 " + ChatColor.GREEN + p.getLevel() + ChatColor.WHITE + "이 되었습니다!");
        }

    }
}
