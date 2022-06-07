package solarion.solarion.Command;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class ResetCommand implements CommandExecutor {
    public static ItemStack resetBook = new ItemStack(Material.BOOK);
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {


            Player p = (Player) sender;


            ItemMeta resetBookMeta = resetBook.getItemMeta();

            resetBookMeta.setDisplayName(ChatColor.RED + "초기화 책");
            List<String> resetBookLore = new ArrayList<String>();

            resetBookLore.add("우클릭시 스탯이 초기화 됩니다.");

            resetBookMeta.setLore(resetBookLore);
            resetBookMeta.setCustomModelData(3);
            resetBook.setItemMeta(resetBookMeta);

            p.getInventory().addItem(resetBook);



        return false;
    }
}
