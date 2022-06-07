package solarion.solarion.Event;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import solarion.solarion.Db.StatDb;
import solarion.solarion.Db.TitleDb;
import solarion.solarion.Hash;

import static solarion.solarion.Hash.addValue;
import static solarion.solarion.Hash.getValue;
import static solarion.solarion.Solarion.User_List;


public class ItemRightClick implements Listener {

    public void ItemRightClick() {
    }

    @EventHandler
    public void ItemRightClick(PlayerInteractEvent e){
        Player p = e.getPlayer();
        Action a = e.getAction();

        if(a== Action.RIGHT_CLICK_AIR||a==Action.RIGHT_CLICK_BLOCK) {
            if (p.getItemInHand().getItemMeta().hasCustomModelData()) {
                if (p.getItemInHand().getType().equals(Material.BOOK)&&p.getItemInHand().getItemMeta().getCustomModelData() == 3) {

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

                    addValue("스탯포인트", p, (int) getValue("스탯포인트", p) + (int) getValue("민첩", p) + (int) getValue("힘", p) + (int) getValue("체력", p) + (int) getValue("재주", p) + (int) getValue("지능", p));
                    addValue("민첩", p, 0);
                    addValue("힘", p, 0);
                    addValue("체력", p, 0);
                    addValue("재주", p, 0);
                    addValue("지능", p, 0);
                    addValue("마나", p, 0);
                    addValue("기본마나", p, 0);

                    addValue("기본마나", p, 100);
                    p.setMaxHealth(20);
                    p.getAttribute(Attribute.GENERIC_ATTACK_DAMAGE).setBaseValue(1);
                    p.setWalkSpeed((float) 0.2);

                    if(p.getItemInHand().getItemMeta().getCustomModelData() == 3) {
                        p.getInventory().remove(Material.BOOK);
                    }

                    StatDb db_conn = new StatDb();
                    if (db_conn.insertMember(p) == 0) db_conn.db_PlayerInfo(p);

                    addValue("민첩",p,User_List.get(p.getUniqueId().toString()).get_agility());
                    addValue("힘",p,User_List.get(p.getUniqueId().toString()).get_strength());
                    addValue("체력",p,User_List.get(p.getUniqueId().toString()).get_health());
                    addValue("재주",p,User_List.get(p.getUniqueId().toString()).get_skill());
                    addValue("지능",p,User_List.get(p.getUniqueId().toString()).get_Intellect());

                    p.sendMessage(ChatColor.RED + "스탯이 초기화 되었습니다.");
                } else {
                    if(p.getItemInHand().getItemMeta().getCustomModelData() == 2) {
                        p.getInventory().remove(Material.BOOK);
                    }
                    if((int)getValue("타이틀",p)==0) {
                        addValue("타이틀", p, 1);
                    }else{
                        addValue("타이틀", p, 0);
                    }


                    TitleDb db_conn = new TitleDb();
                    if(db_conn.insertMember(p) == 0) db_conn.db_PlayerInfo(p);
                    else p.kickPlayer("데이터베이스에서 정보를 로드중 오류가 발생 했습니다.");

                    p.sendMessage(ChatColor.GREEN + "칭호가 설정 되었습니다");

                }
            }
        }else{}
    }

}
