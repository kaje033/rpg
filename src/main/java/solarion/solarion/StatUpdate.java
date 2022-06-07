package solarion.solarion;

import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.ArrayList;
import java.util.List;

import static solarion.solarion.Command.StatCommand.inv;
import static solarion.solarion.Command.StatCommand.p;

public class StatUpdate {
    public static void Update(){
        if (Hash.getValue("스탯포인트",p)==null) {
            Hash.addValue("스탯포인트", p, 0);

            //----------------------------민첩-------------------------------------
            ItemStack agil = new ItemStack(Material.IRON_INGOT);
            ItemMeta agilMeta = agil.getItemMeta();

            agilMeta.setDisplayName(ChatColor.WHITE + "민첩");
            List<String> agilLore = new ArrayList<String>();


            if (Hash.getValue("민첩", p) == null) {
                Hash.addValue("민첩", p, 0);
                agilLore.add(ChatColor.GREEN + "민첩: " + Hash.getValue("민첩", p));

                agilLore.add(ChatColor.WHITE + "이동속도 0.25% 증가,회피확률 0.15% 증가");
            } else {
                agilLore.add(ChatColor.GREEN + "민첩: " + Hash.getValue("민첩", p));
                agilLore.add(ChatColor.WHITE + "이동속도 0.25% 증가,회피확률 0.15% 증가");
            }

            agilMeta.setLore(agilLore);
            agilMeta.setCustomModelData(1);
            agil.setItemMeta(agilMeta);


            //----------------------------힘--------------------------------------
            ItemStack power = new ItemStack(Material.IRON_INGOT);
            ItemMeta powerMeta = agil.getItemMeta();

            powerMeta.setDisplayName(ChatColor.RED + "힘");
            List<String> powerLore = new ArrayList<String>();

            if (Hash.getValue("힘", p) == null) {
                Hash.addValue("힘", p, 0);
                powerLore.add(ChatColor.RED + "힘: " + ChatColor.RED + Hash.getValue("힘", p));
                powerLore.add(ChatColor.RED + "공격력 1 증가");
            } else {
                powerLore.add(ChatColor.GREEN + "힘: " + ChatColor.RED + Hash.getValue("힘", p));
                powerLore.add(ChatColor.RED + "공격력 1 증가");
            }

            powerMeta.setLore(powerLore);
            powerMeta.setCustomModelData(2);
            power.setItemMeta(powerMeta);


            //-----------------------------체력------------------------------------
            ItemStack health = new ItemStack(Material.IRON_INGOT);
            ItemMeta healthMeta = health.getItemMeta();

            healthMeta.setDisplayName(ChatColor.LIGHT_PURPLE + "체력");
            List<String> healthLore = new ArrayList<String>();

            if (Hash.getValue("체력", p) == null) {
                Hash.addValue("체력", p, 0);
                healthLore.add(ChatColor.GREEN + "체력: " + ChatColor.LIGHT_PURPLE + Hash.getValue("체력", p));
                healthLore.add(ChatColor.LIGHT_PURPLE + "체력 2 증가");
            } else {
                healthLore.add(ChatColor.GREEN + "체력: " + ChatColor.LIGHT_PURPLE + Hash.getValue("체력", p));
                healthLore.add(ChatColor.LIGHT_PURPLE + "체력 2 증가");
            }

            healthMeta.setLore(healthLore);
            healthMeta.setCustomModelData(3);
            health.setItemMeta(healthMeta);

            //----------------------------재주-------------------------------------
            ItemStack craft = new ItemStack(Material.IRON_INGOT);
            ItemMeta craftMeta = craft.getItemMeta();

            craftMeta.setDisplayName(ChatColor.YELLOW + "재주");
            List<String> craftLore = new ArrayList<String>();


            if (Hash.getValue("재주", p) == null) {
                Hash.addValue("재주", p, 0);
                craftLore.add(ChatColor.GREEN + "재주: " + ChatColor.YELLOW + Hash.getValue("재주", p));
                craftLore.add(ChatColor.YELLOW + "크리티컬 확률 0.2% 증가");
            } else {
                craftLore.add(ChatColor.GREEN + "재주: " + ChatColor.YELLOW + Hash.getValue("재주", p));
                craftLore.add(ChatColor.YELLOW + "크리티컬 확률 0.2% 증가");
            }

            craftMeta.setLore(craftLore);
            craftMeta.setCustomModelData(4);
            craft.setItemMeta(craftMeta);

            //----------------------------지능-------------------------------------
            ItemStack intelli = new ItemStack(Material.IRON_INGOT);
            ItemMeta intelliMeta = intelli.getItemMeta();

            intelliMeta.setDisplayName(ChatColor.BLUE + "지능");
            List<String> intelliLore = new ArrayList<String>();


            if (Hash.getValue("지능", p) == null) {
                Hash.addValue("지능", p, 0);
                intelliLore.add(ChatColor.GREEN + "지능: " + ChatColor.BLUE + Hash.getValue("지능", p));
                intelliLore.add(ChatColor.BLUE + "마나 1증가");

            } else {
                intelliLore.add(ChatColor.GREEN + "지능: " + ChatColor.BLUE + Hash.getValue("지능", p));
                intelliLore.add(ChatColor.BLUE + "마나 1증가");
            }

            intelliMeta.setLore(intelliLore);
            intelliMeta.setCustomModelData(5);
            intelli.setItemMeta(intelliMeta);


            //----------------------------플레이어머리-------------------------------------
            ItemStack head = new ItemStack(Material.PLAYER_HEAD);
            SkullMeta headMeta = (SkullMeta) head.getItemMeta();

            headMeta.setDisplayName(ChatColor.GOLD + p.getName());
            List<String> headLore = new ArrayList<String>();


            headLore.add(ChatColor.GREEN + "스탯포인트: " + ChatColor.GOLD + Hash.getValue("스탯포인트", p));
            headLore.add(ChatColor.GREEN + "민첩: " + ChatColor.WHITE + Hash.getValue("민첩", p));
            headLore.add(ChatColor.GREEN + "힘: " + ChatColor.RED + Hash.getValue("힘", p));
            headLore.add(ChatColor.GREEN + "체력: " + ChatColor.LIGHT_PURPLE + Hash.getValue("체력", p));
            headLore.add(ChatColor.GREEN + "재주: " + ChatColor.YELLOW + Hash.getValue("재주", p));
            headLore.add(ChatColor.GREEN + "지능: " + ChatColor.BLUE + Hash.getValue("지능", p));


            headMeta.setLore(headLore);
            headMeta.setCustomModelData(6);
            headMeta.setOwner(p.getName());
            head.setItemMeta(headMeta);

            inv.setItem(4, head);
            inv.setItem(9, agil);
            inv.setItem(11, power);
            inv.setItem(13, health);
            inv.setItem(15, craft);
            inv.setItem(17, intelli);
        }
        else{
            //----------------------------민첩-------------------------------------
            ItemStack agil = new ItemStack(Material.IRON_INGOT);
            ItemMeta agilMeta = agil.getItemMeta();

            agilMeta.setDisplayName(ChatColor.WHITE + "민첩");
            List<String> agilLore = new ArrayList<String>();


            if (Hash.getValue("민첩", p) == null) {
                Hash.addValue("민첩", p, 0);
                agilLore.add(ChatColor.GREEN + "민첩: " + Hash.getValue("민첩", p));

                agilLore.add(ChatColor.WHITE+"이동속도 0.25% 증가,회피확률 0.15% 증가");
            } else {
                agilLore.add(ChatColor.GREEN + "민첩: " + Hash.getValue("민첩", p));
                agilLore.add(ChatColor.WHITE+"이동속도 0.25% 증가,회피확률 0.15% 증가");
            }

            agilMeta.setLore(agilLore);
            agilMeta.setCustomModelData(1);
            agil.setItemMeta(agilMeta);


            //----------------------------힘--------------------------------------
            ItemStack power = new ItemStack(Material.IRON_INGOT);
            ItemMeta powerMeta = agil.getItemMeta();

            powerMeta.setDisplayName(ChatColor.RED + "힘");
            List<String> powerLore = new ArrayList<String>();

            if (Hash.getValue("힘", p) == null) {
                Hash.addValue("힘", p, 0);
                powerLore.add(ChatColor.RED + "힘: " + ChatColor.RED+Hash.getValue("힘", p));
                powerLore.add(ChatColor.RED+"공격력 1 증가");
            } else {
                powerLore.add(ChatColor.GREEN + "힘: " + ChatColor.RED + Hash.getValue("힘", p));
                powerLore.add(ChatColor.RED+"공격력 1 증가");
            }

            powerMeta.setLore(powerLore);
            powerMeta.setCustomModelData(2);
            power.setItemMeta(powerMeta);


            //-----------------------------체력------------------------------------
            ItemStack health = new ItemStack(Material.IRON_INGOT);
            ItemMeta healthMeta = health.getItemMeta();

            healthMeta.setDisplayName(ChatColor.LIGHT_PURPLE + "체력");
            List<String> healthLore = new ArrayList<String>();

            if (Hash.getValue("체력", p) == null) {
                Hash.addValue("체력", p, 0);
                healthLore.add(ChatColor.GREEN + "체력: " + ChatColor.LIGHT_PURPLE+Hash.getValue("체력", p));
                healthLore.add(ChatColor.LIGHT_PURPLE+"체력 2 증가");
            } else {
                healthLore.add(ChatColor.GREEN + "체력: " + ChatColor.LIGHT_PURPLE + Hash.getValue("체력", p));
                healthLore.add(ChatColor.LIGHT_PURPLE+"체력 2 증가");
            }

            healthMeta.setLore(healthLore);
            healthMeta.setCustomModelData(3);
            health.setItemMeta(healthMeta);

            //----------------------------재주-------------------------------------
            ItemStack craft = new ItemStack(Material.IRON_INGOT);
            ItemMeta craftMeta = craft.getItemMeta();

            craftMeta.setDisplayName(ChatColor.YELLOW + "재주");
            List<String> craftLore = new ArrayList<String>();


            if (Hash.getValue("재주", p) == null) {
                Hash.addValue("재주", p, 0);
                craftLore.add(ChatColor.GREEN + "재주: "+ ChatColor.YELLOW  + Hash.getValue("재주", p));
                craftLore.add(ChatColor.YELLOW+"크리티컬 확률 0.2% 증가");
            } else {
                craftLore.add(ChatColor.GREEN + "재주: " + ChatColor.YELLOW + Hash.getValue("재주", p));
                craftLore.add(ChatColor.YELLOW+"크리티컬 확률 0.2% 증가");
            }

            craftMeta.setLore(craftLore);
            craftMeta.setCustomModelData(4);
            craft.setItemMeta(craftMeta);

            //----------------------------지능-------------------------------------
            ItemStack intelli = new ItemStack(Material.IRON_INGOT);
            ItemMeta intelliMeta = intelli.getItemMeta();

            intelliMeta.setDisplayName(ChatColor.BLUE + "지능");
            List<String> intelliLore = new ArrayList<String>();


            if (Hash.getValue("지능", p) == null) {
                Hash.addValue("지능", p, 0);
                intelliLore.add(ChatColor.GREEN + "지능: " + ChatColor.BLUE+ Hash.getValue("지능", p));
                intelliLore.add(ChatColor.BLUE+"마나 1증가");

            } else {
                intelliLore.add(ChatColor.GREEN + "지능: " + ChatColor.BLUE + Hash.getValue("지능", p));
                intelliLore.add(ChatColor.BLUE+"마나 1증가");
            }

            intelliMeta.setLore(intelliLore);
            intelliMeta.setCustomModelData(5);
            intelli.setItemMeta(intelliMeta);


            //----------------------------플레이어머리-------------------------------------
            ItemStack head = new ItemStack(Material.PLAYER_HEAD);
            SkullMeta headMeta = (SkullMeta) head.getItemMeta();

            headMeta.setDisplayName(ChatColor.GOLD + p.getName());
            List<String> headLore = new ArrayList<String>();


            headLore.add(ChatColor.GREEN + "스탯포인트: " + ChatColor.GOLD + Hash.getValue("스탯포인트", p));
            headLore.add(ChatColor.GREEN + "민첩: " + ChatColor.WHITE + Hash.getValue("민첩", p));
            headLore.add(ChatColor.GREEN + "힘: " + ChatColor.RED + Hash.getValue("힘", p));
            headLore.add(ChatColor.GREEN + "체력: " + ChatColor.LIGHT_PURPLE + Hash.getValue("체력", p));
            headLore.add(ChatColor.GREEN + "재주: " + ChatColor.YELLOW + Hash.getValue("재주", p));
            headLore.add(ChatColor.GREEN + "지능: " + ChatColor.BLUE + Hash.getValue("지능", p));


            headMeta.setLore(headLore);
            headMeta.setCustomModelData(6);
            headMeta.setOwner(p.getName());
            head.setItemMeta(headMeta);

            inv.setItem(4, head);
            inv.setItem(9, agil);
            inv.setItem(11, power);
            inv.setItem(13, health);
            inv.setItem(15, craft);
            inv.setItem(17, intelli);
        }

    }


}
