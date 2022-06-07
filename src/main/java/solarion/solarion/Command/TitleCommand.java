package solarion.solarion.Command;


import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import static solarion.solarion.Hash.*;



public class TitleCommand implements CommandExecutor {

    public static ChatColor color;

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player p = (Player) sender;
        if (sender.isOp()) {

            if(args.length==0) {
                p.sendMessage(ChatColor.GREEN + "/칭호 {색(대문자)} {칭호 명}");
            }else {
                color = ChatColor.valueOf(args[0]);

                addValue("칭호", p, "");
                addValue("타이틀", p, 0);

                if (getValue("칭호", p) == null) {
                    addValue("칭호", p, "");
                }

                addValue("칭호", p, args[1]);

                ItemStack title = new ItemStack(Material.BOOK);
                ItemMeta titleMeta = title.getItemMeta();


                titleMeta.setDisplayName("칭호: " + color + getValue("칭호", p));

                titleMeta.setCustomModelData(2);
                title.setItemMeta(titleMeta);

                p.getInventory().addItem(title);

            }
        }else {
            sender.sendMessage("당신은 이 명령어를 사용 할 권한이 없습니다");
        }



        return false;
    }

}
