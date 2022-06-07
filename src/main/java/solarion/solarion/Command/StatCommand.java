package solarion.solarion.Command;

import solarion.solarion.Solarion;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import solarion.solarion.StatUpdate;


import static org.bukkit.Bukkit.createInventory;

public class StatCommand implements CommandExecutor {

    public StatCommand() {
    }

    public StatCommand(Solarion plugin){
        this.plugin = plugin;
    }
    public Solarion plugin;


    public static Player p;
    public static Inventory inv;

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        p = (Player) sender;

        inv = createInventory(null,27,p.getName()+"'s stat");

        StatUpdate.Update();

//        StatDb db_conn = new StatDb();
//        db_conn.db_PlayerInfo(p);

        p.openInventory(inv);


        return false;
    }

}
