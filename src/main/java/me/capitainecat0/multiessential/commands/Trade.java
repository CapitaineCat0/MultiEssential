package me.capitainecat0.multiessential.commands;

import me.capitainecat0.multiessential.MultiEssential;
import me.capitainecat0.multiessential.utils.TradeListener;
import net.capitainecat0.multiessential.api.InventoryAPI;
import net.capitainecat0.multiessential.api.ItemAPI;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.HashMap;
import java.util.Optional;

public class Trade implements CommandExecutor {

    TradeListener tradeList;
    HashMap<Player, Player> TradeRequest = new HashMap<>();
    public Trade(TradeListener listener){
        tradeList = listener;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("trade")) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                if (!player.hasPermission("multiessential.trade") && !player.hasPermission("multiessential.*")) {
                    player.sendMessage(MultiEssential.getInstance().formatText(MultiEssential.getInstance().getConfig().getString("prefix") + "&r " +
                            MultiEssential.getInstance().langConfig.getString("permissions.trade")));
                    if (MultiEssential.getInstance().getConfig().getBoolean("sounds.warn")) {
                        player.playSound(player.getLocation(), Sound.ENTITY_VILLAGER_NO, 100, 1);
                    }
                } else {
                    if (args.length == 0) {
                        player.sendMessage(MultiEssential.getInstance().formatText(MultiEssential.getInstance().getConfig().getString("prefix") + "&r " +
                                MultiEssential.getInstance().langConfig.getString("trade.error")));
                        if (MultiEssential.getInstance().getConfig().getBoolean("sounds.warn")) {
                            player.playSound(player.getLocation(), Sound.ENTITY_VILLAGER_HURT, 100, 1);
                        }
                    }else if(args.length == 1) {
                        Player target = Bukkit.getPlayerExact(args[0]);
                        if (target instanceof Player) {
                                player.sendMessage(MultiEssential.getInstance().formatText(MultiEssential.getInstance().getConfig().getString("prefix") + "&r " +
                                        MultiEssential.getInstance().langConfig.getString("trade.sender.sent").replace("{PLAYER}", target.getDisplayName())));
                                TradeRequest.put(target, player);
                                target.sendMessage(MultiEssential.getInstance().formatText(MultiEssential.getInstance().getConfig().getString("prefix") + "&r " +
                                        MultiEssential.getInstance().langConfig.getString("trade.reciever.message").replace("{SENDER}", player.getDisplayName())));
                                if(MultiEssential.getInstance().getConfig().getBoolean("sounds.request")){
                                    player.playSound(player.getLocation(), Sound.ENTITY_VILLAGER_TRADE, 100, 1);
                                }
                                if(MultiEssential.getInstance().getConfig().getBoolean("sounds.request")){
                                    target.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 100, 100);
                                }
                        } else if(args[0].equalsIgnoreCase("accept") || args[0].equalsIgnoreCase("yes")){
                            if(TradeRequest.containsKey(player)){
                                Player TradeTarget = TradeRequest.get(player);
                                if(Bukkit.getOnlinePlayers().contains(TradeTarget)){
                                    InventoryAPI inv = InventoryAPI.create(MultiEssential.getInstance());
                                    inv.setTitle(MultiEssential.getInstance().formatText(MultiEssential.getInstance().getConfig().getString("trade.inventory_name")));
                                    inv.setSize(9 * 6);
                                    inv.setBorder(new ItemStack(Material.GRAY_STAINED_GLASS_PANE, 1));
                                    inv.addItem(53, new ItemStack(Material.RED_STAINED_GLASS_PANE, 1), true, InventoryClickEvent ->{
                                        player.closeInventory();
                                    });
                                    inv.addItem(52, new ItemStack(Material.MAGMA_CREAM, 1), true, InventoryClickEvent ->{
                                        inv.build(player);
                                        inv.build(TradeTarget);
                                    });

                                    inv.build(player);
                                    inv.build(TradeTarget);

                                    TradeRequest.remove(player);
                                    tradeList.addPlayerToList(player, null);
                                }else{
                                    player.sendMessage(MultiEssential.getInstance().formatText(MultiEssential.getInstance().getConfig().getString("prefix") + "&r " +
                                            MultiEssential.getInstance().langConfig.getString("messages.not_a_player").replace("{PLAYER}", args[0])));
                                    TradeRequest.remove(player);
                                    if(MultiEssential.getInstance().getConfig().getBoolean("sounds.warn")){
                                        player.playSound(player.getLocation(), Sound.ENTITY_VILLAGER_HURT, 100, 1);
                                    }
                                }
                            }
                        }
                    }
                }
            } else {
                ConsoleCommandSender console = Bukkit.getConsoleSender();
                console.sendMessage(MultiEssential.getInstance().langConfig.getString("messages.console"));
            }
        }return false;
    }
}
