package me.capitainecat0.multiessential.moderation.commands;

import me.capitainecat0.multiessential.MultiEssential;
import net.md_5.bungee.api.chat.ClickEvent;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;

import java.awt.*;
import java.util.UUID;

public class Whois implements CommandExecutor {
    public Whois(MultiEssential instance) {}

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("whois")) {
            if(args.length <= 0){
                sender.sendMessage(MultiEssential.getInstance().formatText(MultiEssential.getInstance().getConfig().getString("prefix") + "&r " +
                        MultiEssential.getInstance().langConfig.getString("messages.whois_error")));
                if(MultiEssential.getInstance().getConfig().getBoolean("sounds.warn")){
                    if(sender instanceof Player){
                        Player player = (Player)sender;
                        player.playSound(player.getLocation(), Sound.ENTITY_VILLAGER_NO, 100, 1);
                    }else{return true;}
                }
            }else {
                Player target = Bukkit.getPlayerExact(args[0]);
                if (!sender.hasPermission("multiessential.whois") && !sender.hasPermission("multiessential.admin") && !sender.hasPermission("multiessential.*")) {
                    sender.sendMessage(MultiEssential.getInstance().formatText(MultiEssential.getInstance().getConfig().getString("prefix") + "&r " +
                            MultiEssential.getInstance().langConfig.getString("permissions.whois")));
                }
                if (target instanceof Player) {
                    TextComponent coordinates = new TextComponent("§6Coordinates§8: §eX §c" + target.getLocation().getX() + " §eY§c " + target.getLocation().getY() + " §eZ§c " + target.getLocation().getZ());
                    coordinates.setBold(true);
                    coordinates.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/tp " + target.getDisplayName()));
                    sender.sendMessage("§6Pseudo§8: §c" + target.getDisplayName());
                    //sender.sendMessage("§6Pseudo serveur§8: §a" + target.getCustomName());
                    sender.sendMessage("§6Pseudo list§8: §f" + target.getPlayerListName());
                    sender.sendMessage("§6UUID§8: §e" + target.getUniqueId());
                    sender.sendMessage("§6IP adress§8: §c" + target.getAddress());
                    sender.spigot().sendMessage(coordinates);
                    sender.sendMessage("§6World§8: §5" + target.getWorld().getName());
                    sender.sendMessage("§6Fly-mode§8: §a" + target.getAllowFlight());
                    sender.sendMessage("§6Gamemode§8: §d" + target.getGameMode());
                    sender.sendMessage("§6Invulnerability§8: §e" + target.isInvulnerable());
                    sender.sendMessage("§6Operator§8: §b" + target.isOp());
                    //sender.sendMessage("§6En ligne§8: §a" + target.isOnline());
                    //sender.sendMessage("§6Bannis§8: §3" + target.isBanned());
                    sender.sendMessage("§6Whitelisted§8: §f" + target.isWhitelisted());
                } else {
                    sender.sendMessage(MultiEssential.getInstance().formatText(MultiEssential.getInstance().getConfig().getString("prefix") + "&r " +
                            MultiEssential.getInstance().langConfig.getString("messages.not_a_player").replace("{PLAYER}", args[0])));
                }
            }
        } return false;
    }
}