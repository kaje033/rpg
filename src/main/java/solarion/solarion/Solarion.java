package solarion.solarion;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;
import solarion.solarion.ActionBar.ActionBar;
import solarion.solarion.Command.ItemRightClick;
import solarion.solarion.Command.ResetCommand;
import solarion.solarion.Command.StatCommand;
import solarion.solarion.Command.TitleCommand;
import solarion.solarion.Db.MainDb;
import solarion.solarion.Db.StatDb;
import solarion.solarion.Db.user;
import solarion.solarion.Event.EntityDamage;
import solarion.solarion.Event.InvClickEvent;
import solarion.solarion.Exp.Level;

import java.util.HashMap;

import static solarion.solarion.Hash.addValue;

public final class Solarion extends JavaPlugin implements Listener{

    public Solarion(){}

    MainDb db_conn = new MainDb();
    public static HashMap<String, user> User_List = new HashMap<String, user>();

    @Override
    public void onEnable() {
        System.out.println("\n");
        System.out.println("\n");
        System.out.println("\n");
        System.out.println("§c 플러그인이 활성화 되었습니다");
        System.out.println("§6 made by question_Mark\n");
        System.out.println("\n");
        System.out.println("\n");

        getCommand("스탯").setExecutor(new StatCommand(this));
        getCommand("칭호").setExecutor(new TitleCommand());
        getCommand("초기화").setExecutor(new ResetCommand());

        getServer().getPluginManager().registerEvents(new InvClickEvent(this), this);
        getServer().getPluginManager().registerEvents(new ItemRightClick(), this);
        getServer().getPluginManager().registerEvents(new EntityDamage(), this);
        getServer().getPluginManager().registerEvents(new Level(),this);
        getServer().getPluginManager().registerEvents(new Title(),this);
        getServer().getPluginManager().registerEvents(new ActionBar(), this);

        getServer().getPluginManager().registerEvents(this,this);

    }

    @Override
    public void onDisable() {
        System.out.println("\n");
        System.out.println("\n");
        System.out.println("\n");
        System.out.println("§c 플러그인이 비활성화 되었습니다");
        System.out.println("§6 made by question_Mark\n");
        System.out.println("\n");
        System.out.println("\n");
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        Player player = e.getPlayer();
        if(db_conn.insertMember(player) == 0) db_conn.db_PlayerInfo(player);
        else player.kickPlayer("데이터베이스에서 정보를 로드중 오류가 발생 했습니다.");


        Title.color1 = User_List.get(player.getUniqueId().toString()).get_title_color();

        StatDb db_conn = new StatDb();
        if (db_conn.insertMember(player) == 0) db_conn.db_PlayerInfo(player);

        addValue("민첩",player,User_List.get(player.getUniqueId().toString()).get_agility());
        addValue("힘",player,User_List.get(player.getUniqueId().toString()).get_strength());
        addValue("체력",player,User_List.get(player.getUniqueId().toString()).get_health());
        addValue("재주",player,User_List.get(player.getUniqueId().toString()).get_skill());
        addValue("지능",player,User_List.get(player.getUniqueId().toString()).get_Intellect());


//        player.sendMessage("데이터 베이스에서 불러온 당신의 정보 입니다.");
//        player.sendMessage("당신의 UUID : " + User_List.get(player.getUniqueId().toString()).getU_uuid());
//        player.sendMessage("당신의 닉네임 : " + User_List.get(player.getUniqueId().toString()).getU_name());



    }
}
