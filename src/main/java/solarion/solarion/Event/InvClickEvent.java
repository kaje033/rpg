package solarion.solarion.Event;

import org.bukkit.event.Listener;
import solarion.solarion.Db.StatDb;
import solarion.solarion.Hash;
import solarion.solarion.Solarion;
import org.bukkit.ChatColor;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.InventoryClickEvent;
import solarion.solarion.StatUpdate;

import static solarion.solarion.Hash.*;
import static solarion.solarion.Solarion.User_List;

public class InvClickEvent implements Listener {


    public InvClickEvent(Solarion plugin){this.plugin = plugin;}
    public Solarion plugin;


    // Player p;

    @EventHandler
    public void InvClickEvent(InventoryClickEvent e){
        //stat();
        Player p = (Player) e.getWhoClicked();
        String invName = e.getView().getTitle();



        if(!invName.equals(p.getName()+"'s stat"))return;
        if(e.getCurrentItem()==null)return;

        if(e.getCurrentItem().getItemMeta().getCustomModelData()==1){
            e.setCancelled(true);

            if((int)Hash.getValue("스탯포인트",p)<=0){
                p.sendMessage(ChatColor.RED+"스탯포인트가 부족합니다.");
            }else {
                if((Integer)Hash.getValue("민첩",p)>=500) {
                    p.sendMessage(ChatColor.RED+"민첩 스탯이 최대치입니다.");
                }else{
                    addValue("민첩", p, (Integer) getValue("민첩", p) + 1);
                    p.setWalkSpeed((float) (0.2 + ((Integer)Hash.getValue("민첩",p) * 0.2 * 0.0025)));
                    p.sendMessage(ChatColor.GREEN + "민첩 스탯이 " + ChatColor.WHITE + getValue("민첩", p) + ChatColor.GREEN + "로 증가되었습니다.");
                    addValue("스탯포인트",p,(Integer)getValue("스탯포인트",p)-1);
                }
            }

        }else if(e.getCurrentItem().getItemMeta().getCustomModelData()==2){
            e.setCancelled(true);

            if((int)Hash.getValue("스탯포인트",p)<=0){
                p.sendMessage(ChatColor.RED+"스탯포인트가 부족합니다.");
            }else {
                if ((int)Hash.getValue("힘", p) >= 500) {
                    p.sendMessage(ChatColor.RED+"힘 스탯이 최대치입니다.");
                }else{
                    addValue("힘", p, (int) getValue("힘", p) + 1);
                    p.sendMessage(ChatColor.GREEN + "힘 스탯이 " + ChatColor.RED + getValue("힘", p) + ChatColor.GREEN + "로 증가되었습니다.");
                    p.getAttribute(Attribute.GENERIC_ATTACK_DAMAGE).setBaseValue((int)getValue("힘",p)-1);
                    addValue("스탯포인트",p,(int)getValue("스탯포인트",p)-1);
                }
            }

        }else if(e.getCurrentItem().getItemMeta().getCustomModelData()==3){
            e.setCancelled(true);

            if((int)Hash.getValue("스탯포인트",p)<=0){
                p.sendMessage(ChatColor.RED+"스탯포인트가 부족합니다.");
            }else {
                if ((int) Hash.getValue("체력", p) >= 500) {
                    p.sendMessage(ChatColor.RED+"체력 스탯이 최대치입니다.");
                }else{
                    addValue("체력", p, (int) getValue("체력", p) + 1);
                    p.setMaxHealth((int)Hash.getValue("체력",p) * 2 + 20);
                    p.sendMessage(ChatColor.GREEN + "체력 스탯이 " + ChatColor.LIGHT_PURPLE + getValue("체력", p) + ChatColor.GREEN + "로 증가되었습니다.");
                    addValue("스탯포인트",p,(int)getValue("스탯포인트",p)-1);
                }
            }

        }else if(e.getCurrentItem().getItemMeta().getCustomModelData()==4){
            e.setCancelled(true);

            if((int)Hash.getValue("스탯포인트",p)<=0){
                p.sendMessage(ChatColor.RED+"스탯포인트가 부족합니다.");
            }else {
                if ((int) Hash.getValue("재주", p) >= 500) {
                    p.sendMessage(ChatColor.RED+"재주 스탯이 최대치입니다.");
                }else{
                    addValue("재주", p, (int) getValue("재주", p) + 1);
                    p.sendMessage(ChatColor.GREEN + "재주 스탯이 " + ChatColor.YELLOW + getValue("재주", p) + ChatColor.GREEN + "로 증가되었습니다.");
                    addValue("스탯포인트",p,(int)getValue("스탯포인트",p)-1);

                }
            }

        }else if(e.getCurrentItem().getItemMeta().getCustomModelData()==5){
            e.setCancelled(true);

            if((int)Hash.getValue("스탯포인트",p)<=0){
                p.sendMessage(ChatColor.RED+"스탯포인트가 부족합니다.");
            }else {
                if ((int) Hash.getValue("지능", p) >= 500) {
                    p.sendMessage(ChatColor.RED+"지능 스탯이 최대치입니다.");
                }else{
                    addValue("지능", p, (int) getValue("지능", p) + 1);
                    p.sendMessage(ChatColor.GREEN + "지능 스탯이 " + ChatColor.BLUE + getValue("지능", p) + ChatColor.GREEN + "로 증가되었습니다.");
                    if(getValue("기본마나",p)==null) addValue("기본마나",p,0);
                    addValue("기본마나",p,(int)getValue("기본마나",p)+(int)getValue("지능", p));
                    addValue("스탯포인트",p,(int)getValue("스탯포인트",p)-1);
                }
            }

        }else if(e.getCurrentItem().getItemMeta().getCustomModelData()==6) {
            e.setCancelled(true);
        }

        StatUpdate.Update();

        StatDb db_conn = new StatDb();
        if (db_conn.insertMember(p) == 0) db_conn.db_PlayerInfo(p);
        
        addValue("민첩",p,User_List.get(p.getUniqueId().toString()).get_agility());
        addValue("힘",p,User_List.get(p.getUniqueId().toString()).get_strength());
        addValue("체력",p,User_List.get(p.getUniqueId().toString()).get_health());
        addValue("재주",p,User_List.get(p.getUniqueId().toString()).get_skill());
        addValue("지능",p,User_List.get(p.getUniqueId().toString()).get_Intellect());

    }
}
