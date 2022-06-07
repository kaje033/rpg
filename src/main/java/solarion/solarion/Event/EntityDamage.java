package solarion.solarion.Event;

import net.md_5.bungee.api.chat.*;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Particle;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import solarion.solarion.Hash;


import java.security.SecureRandom;

public class EntityDamage implements Listener {

    SecureRandom rand = new SecureRandom();



    public EntityDamage() {
    }

    @EventHandler
    public void EntityDamge(EntityDamageByEntityEvent e) {
        double damage = e.getDamage();

        if (e.getDamager() instanceof Player) {
            Player p = (Player) e.getDamager();


            if (Hash.getValue("재주", p) == null) {
                Hash.addValue("재주", p, 0);
            }


            if (rand.nextInt(1000) <= (int) Hash.getValue("재주", p) * 2) {
                damage = damage * 2;
                p.getWorld().spawnParticle(Particle.CRIT, e.getEntity().getLocation().getX(),e.getEntity().getLocation().getY()+1, e.getEntity().getLocation().getZ(),40);

            }

            damage = Math.round(damage * 100) / 100;

        }

        Player pl = (Player) e.getEntity();

        if (Hash.getValue("민첩", pl) == null) {
            Hash.addValue("민첩", pl, 0);
        }

        if (rand.nextInt(10000) <= (int) Hash.getValue("민첩", pl) * 15) {
            damage = 0;

            pl.getWorld().spawnParticle(Particle.CRIT_MAGIC, e.getEntity().getLocation().getX(),e.getEntity().getLocation().getY()+1, e.getEntity().getLocation().getZ(),40);
        }

        e.setDamage(damage);

    }
}