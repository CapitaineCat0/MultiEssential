package me.capitainecat0.multiessential.commands;

import me.capitainecat0.multiessential.MultiEssential;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.entity.Player;

import java.io.IOException;

public class MeHelp_1 implements CommandExecutor {
    public MeHelp_1(MultiEssential instance) {}
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player player = (Player) sender;
        if (cmd.getName().equalsIgnoreCase("me") || cmd.getName().equalsIgnoreCase("multie") || cmd.getName().equalsIgnoreCase("multiessential") || cmd.getName().equalsIgnoreCase("multiess") || cmd.getName().equalsIgnoreCase("mess")) {
            if (args.length == 0) {
                TextComponent help = new TextComponent("§7- §6/me help§7 =>" +"§r " + MultiEssential.getInstance().langConfig.getString("help.commands.help.command").replace("&", "§"));
                TextComponent reload = new TextComponent("§7- §6/me reload§7 =>" +"§r " + MultiEssential.getInstance().langConfig.getString("help.commands.reload.command").replace("&", "§"));
                TextComponent name = new TextComponent(MultiEssential.getInstance().langConfig.getString("help.descriptions.name").replace("&", "§") + " §6" + MultiEssential.getInstance().getDescription().getName());
                TextComponent author = new TextComponent(MultiEssential.getInstance().langConfig.getString("help.descriptions.author").replace("&", "§") + " §3" + MultiEssential.getInstance().getDescription().getAuthors());
                TextComponent version = new TextComponent(MultiEssential.getInstance().langConfig.getString("help.descriptions.version").replace("&", "§") + " §e" + MultiEssential.getInstance().getDescription().getVersion());
                TextComponent prefix = new TextComponent(MultiEssential.getInstance().langConfig.getString("help.descriptions.prefix").replace("&", "§") + " §r" + MultiEssential.getInstance().getConfig().getString("prefix").replace("&", "§"));
                TextComponent discord = new TextComponent(MultiEssential.getInstance().langConfig.getString("help.descriptions.discord").replace("&", "§") + "§b " + MultiEssential.getInstance().getDescription().getWebsite());
                TextComponent website = new TextComponent(MultiEssential.getInstance().langConfig.getString("help.descriptions.website").replace("&", "§") + " §6https://github.com/CapitaineCat0/MultiEssential");

                help.setBold(true);
                reload.setBold(true);
                name.setBold(true);
                author.setBold(true);
                version.setBold(true);
                prefix.setBold(true);
                discord.setBold(true);
                website.setBold(true);
                //modules.setBold(true);

                help.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/me help"));
                reload.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/me reload"));
                help.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder(MultiEssential.getInstance().langConfig.getString("help.commands.help.hover").replace("&", "§")).create()));
                reload.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder(MultiEssential.getInstance().langConfig.getString("help.commands.reload.hover").replace("&", "§")).create()));
                name.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder(MultiEssential.getInstance().langConfig.getString("help.descriptions.name").replace("&", "§")).create()));
                author.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder(MultiEssential.getInstance().langConfig.getString("help.descriptions.author").replace("&", "§")).create()));
                version.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder(MultiEssential.getInstance().langConfig.getString("help.descriptions.version").replace("&", "§")).create()));
                prefix.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder(MultiEssential.getInstance().langConfig.getString("help.descriptions.prefix").replace("&", "§")).create()));
                discord.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder(MultiEssential.getInstance().langConfig.getString("help.descriptions.discord").replace("&", "§")).create()));
                website.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder(MultiEssential.getInstance().langConfig.getString("help.descriptions.website").replace("&", "§")).create()));

                player.sendMessage("§a§m-+----------------+- §7 - §e§l{ §6MultiEssential §7- §2[§dinfos§2] §e§l} §7- §a§m-+----------------+-");
                player.spigot().sendMessage(help);
                player.spigot().sendMessage(reload);
                player.spigot().sendMessage(name);
                player.spigot().sendMessage(author);
                player.spigot().sendMessage(version);
                player.spigot().sendMessage(prefix);
                player.spigot().sendMessage(discord);
                player.spigot().sendMessage(website);
                player.sendMessage("§a§m-+----------------------------------------------------------------+-");

            } else if (args[0].equalsIgnoreCase("help")) {

                TextComponent alert = new TextComponent("§7- §6/alert §7<§9message§7> =>" +"§r " + MultiEssential.getInstance().langConfig.getString("help.commands.alert.command").replace("&", "§"));
                TextComponent bc = new TextComponent("§7- §6/bc §7<§9message§7> =>" +"§r " + MultiEssential.getInstance().langConfig.getString("help.commands.bc.command").replace("&", "§"));
                TextComponent ci = new TextComponent("§7- §6/ci §7<§9player§7> =>" +"§r " + MultiEssential.getInstance().langConfig.getString("help.commands.clear.command").replace("&", "§"));
                TextComponent craft = new TextComponent("§7- §6/craft | workbench §7=>" +"§r " + MultiEssential.getInstance().langConfig.getString("help.commands.craft.command").replace("&", "§"));
                TextComponent day = new TextComponent("§7- §6/day §7=>" +"§r " + MultiEssential.getInstance().langConfig.getString("help.commands.day.command").replace("&", "§"));
                TextComponent ec = new TextComponent("§7- §6/ec §7<§9player§7> =>" +"§r " + MultiEssential.getInstance().langConfig.getString("help.commands.enderchest.command").replace("&", "§"));
                TextComponent feed = new TextComponent("§7- §6/feed §7<§9player§7> =>" +"§r " + MultiEssential.getInstance().langConfig.getString("help.commands.feed.command").replace("&", "§"));
                TextComponent fly = new TextComponent("§7- §6/fly §7<§9player§7> =>" +"§r " + MultiEssential.getInstance().langConfig.getString("help.commands.fly.command").replace("&", "§"));
                TextComponent freeze = new TextComponent("§7- §6/freeze §7<§9player§7> =>" +"§r " + MultiEssential.getInstance().langConfig.getString("help.commands.freeze.command").replace("&", "§"));
                TextComponent gm = new TextComponent("§7- §6/gm §7<§dmode§7> [§9player§7] =>" +"§r " + MultiEssential.getInstance().langConfig.getString("help.commands.gamemode.command").replace("&", "§"));
                TextComponent god = new TextComponent("§7- §6/god §7<§9player§7> =>" +"§r " + MultiEssential.getInstance().langConfig.getString("help.commands.god.command").replace("&", "§"));
                TextComponent heal = new TextComponent("§7- §6/heal §7<§9player§7> =>" +"§r " + MultiEssential.getInstance().langConfig.getString("help.commands.heal.command").replace("&", "§"));
                TextComponent hat = new TextComponent("§7- §6/hat §7=> " +"§r " + MultiEssential.getInstance().langConfig.getString("help.commands.hat.command").replace("&", "§"));
                TextComponent invsee = new TextComponent("§7- §6/invsee §7<§9player§7>  =>" +"§r " + MultiEssential.getInstance().langConfig.getString("help.commands.invsee.command").replace("&", "§"));
                TextComponent kb = new TextComponent("§7- §6/kbstick §7=>" +"§r " + MultiEssential.getInstance().langConfig.getString("help.commands.kbstick.command").replace("&", "§"));
                TextComponent next = new TextComponent(MultiEssential.getInstance().langConfig.getString("help.next_page").replace("&", "§"));

                alert.setBold(true);
                bc.setBold(true);
                ci.setBold(true);
                craft.setBold(true);
                ec.setBold(true);
                day.setBold(true);
                feed.setBold(true);
                fly.setBold(true);
                freeze.setBold(true);
                gm.setBold(true);
                god.setBold(true);
                heal.setBold(true);
                hat.setBold(true);
                invsee.setBold(true);
                kb.setBold(true);
                next.setBold(true);

                alert.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder(MultiEssential.getInstance().langConfig.getString("help.commands.alert.hover").replace("&", "§")).create()));
                bc.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder(MultiEssential.getInstance().langConfig.getString("help.commands.bc.hover").replace("&", "§")).create()));
                ci.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder(MultiEssential.getInstance().langConfig.getString("help.commands.clear.hover").replace("&", "§")).create()));
                craft.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder(MultiEssential.getInstance().langConfig.getString("help.commands.craft.hover").replace("&", "§")).create()));
                day.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder(MultiEssential.getInstance().langConfig.getString("help.commands.day.hover").replace("&", "§")).create()));
                ec.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder(MultiEssential.getInstance().langConfig.getString("help.commands.enderchest.hover").replace("&", "§")).create()));
                feed.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder(MultiEssential.getInstance().langConfig.getString("help.commands.feed.hover").replace("&", "§")).create()));
                fly.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder(MultiEssential.getInstance().langConfig.getString("help.commands.fly.hover").replace("&", "§")).create()));
                freeze.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder(MultiEssential.getInstance().langConfig.getString("help.commands.freeze.hover").replace("&", "§")).create()));
                gm.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder(MultiEssential.getInstance().langConfig.getString("help.commands.gamemode.hover").replace("&", "§")).create()));
                god.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder(MultiEssential.getInstance().langConfig.getString("help.commands.god.hover").replace("&", "§")).create()));
                heal.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder(MultiEssential.getInstance().langConfig.getString("help.commands.heal.hover").replace("&", "§")).create()));
                hat.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder(MultiEssential.getInstance().langConfig.getString("help.commands.hat.hover").replace("&", "§")).create()));
                invsee.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder(MultiEssential.getInstance().langConfig.getString("help.commands.invsee.hover").replace("&", "§")).create()));
                kb.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder(MultiEssential.getInstance().langConfig.getString("help.commands.kbstick.hover").replace("&", "§")).create()));
                next.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder(MultiEssential.getInstance().langConfig.getString("help.next_page").replace("&", "§")).create()));

                alert.setClickEvent(new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, "/alert <message>"));
                bc.setClickEvent(new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, "/bc <message>"));
                ci.setClickEvent(new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, "/ci <player>"));
                craft.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/craft"));
                day.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/day"));
                ec.setClickEvent(new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, "/ec <player>"));
                feed.setClickEvent(new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, "/feed <player>"));
                fly.setClickEvent(new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, "/fly <player>"));
                freeze.setClickEvent(new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, "/freeze <player>"));
                gm.setClickEvent(new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, "/gm [mode] <player>"));
                god.setClickEvent(new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, "/god <player>"));
                heal.setClickEvent(new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, "/heal <player>"));
                hat.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/hat"));
                invsee.setClickEvent(new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, "/invsee <player>"));
                kb.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/kbstick"));
                next.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/multiessentialhelppage 2"));

                player.sendMessage("§a§m-+---------------+- §7 - §e§l{ §6MultiEssential §7- §2[page 1] §e§l} §7- §a§m-+---------------+-");
                player.spigot().sendMessage(alert);
                player.spigot().sendMessage(bc);
                player.spigot().sendMessage(ci);
                player.spigot().sendMessage(craft);
                player.spigot().sendMessage(day);
                player.spigot().sendMessage(ec);
                player.spigot().sendMessage(feed);
                player.spigot().sendMessage(fly);
                player.spigot().sendMessage(freeze);
                player.spigot().sendMessage(gm);
                player.spigot().sendMessage(god);
                player.spigot().sendMessage(heal);
                player.spigot().sendMessage(hat);
                player.spigot().sendMessage(invsee);
                player.spigot().sendMessage(kb);
                player.spigot().sendMessage(next);
                player.sendMessage("§a§m-+----------------------------------------------------------------+-");
            }else if (args[0].equalsIgnoreCase("reload")) {
                if (!player.hasPermission("multiessential.reload") && !player.hasPermission("multiessential.admin") && !player.hasPermission("multiessential.*")) {
                    player.sendMessage(MultiEssential.getInstance().getConfig().getString("prefix").replace("&", "§") + "§r"
                            + MultiEssential.getInstance().langConfig.getString("permissions.reload").replace("&", "§"));
                    if(MultiEssential.getInstance().getConfig().getBoolean("sounds.warn")){
                        player.playSound(player.getLocation(), Sound.ENTITY_VILLAGER_NO, 100, 1);
                    }
                } else {
                    player.sendMessage(MultiEssential.getInstance().getConfig().getString("prefix").replace("&", "§") + "§r "
                            + MultiEssential.getInstance().langConfig.getString("messages.reloaded").replace("&", "§"));
                    MultiEssential.getInstance().reloadConfig();
                    if(MultiEssential.getInstance().getConfig().getBoolean("sounds.request")){
                        player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 100, 100);
                    }
                }

            }
        }

        return false;
    }
}
