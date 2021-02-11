package me.capitainecat0.multiessential.commands;

import me.capitainecat0.multiessential.MultiEssential;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class MeHelp_2 implements CommandExecutor {

    public MeHelp_2(MultiEssential instance) {}

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player player = (Player) sender;
        if (cmd.getName().equalsIgnoreCase("multiessentialhelppage")) {
            if (args[0].equals("2")) {
                TextComponent lightning = new TextComponent("§7- §6/lightning §7 =>" + "§r " + MultiEssential.getInstance().langConfig.getString("help.commands.lightning.command").replace("&", "§"));
                TextComponent list = new TextComponent("§7- §6/list §7=>" + "§r " + MultiEssential.getInstance().langConfig.getString("help.commands.list.command").replace("&", "§"));
                TextComponent midday = new TextComponent("§7- §6/midday§7 =>" + "§r " + MultiEssential.getInstance().langConfig.getString("help.commands.midday.command").replace("&", "§"));
                TextComponent midnight = new TextComponent("§7- §6/midnight§7 =>" + "§r " + MultiEssential.getInstance().langConfig.getString("help.commands.midnight.command").replace("&", "§"));
                TextComponent msg = new TextComponent("§7- §6/msg or w §7<§9player§7> §7<§9message§7> =>" + "§r " + MultiEssential.getInstance().langConfig.getString("help.commands.msg.command").replace("&", "§"));
                TextComponent night = new TextComponent("§7- §6/night §7=>" + "§r " + MultiEssential.getInstance().langConfig.getString("help.commands.night.command").replace("&", "§"));
                TextComponent nick = new TextComponent("§7- §6/nick §7<§9pseudo§7>=>" + "§r " + MultiEssential.getInstance().langConfig.getString("help.commands.nick.command").replace("&", "§"));
                TextComponent r = new TextComponent("§7- §6/r §7<§9message§7> =>" + "§r " + MultiEssential.getInstance().langConfig.getString("help.commands.r.command").replace("&", "§"));
                TextComponent reload = new TextComponent("§7- §6/me reload §7=>" + "§r " + MultiEssential.getInstance().langConfig.getString("help.commands.reload.command").replace("&", "§"));
                TextComponent setspawn = new TextComponent("§7- §6/setspawn §7=>" + "§r " + MultiEssential.getInstance().langConfig.getString("help.commands.setspawn.command").replace("&", "§"));
                TextComponent spawn = new TextComponent("§7- §6/spawn §7=>" + "§r " + MultiEssential.getInstance().langConfig.getString("help.commands.spawn.command").replace("&", "§"));
                TextComponent kill = new TextComponent("§7- §6/suicide§7 =>" + "§r " + MultiEssential.getInstance().langConfig.getString("help.commands.suicide.command").replace("&", "§"));
                TextComponent time = new TextComponent("§7- §6/time set §7<§bticks§7> =>" + "§r " + MultiEssential.getInstance().langConfig.getString("help.commands.time.command").replace("&", "§"));
                TextComponent tnt = new TextComponent("§7- §6/tnt §7=>" + "§r " + MultiEssential.getInstance().langConfig.getString("help.commands.tnt.command").replace("&", "§"));
                TextComponent trade = new TextComponent("§7- §6/trade §7<§9player§7> (accept|yes) =>" + "§r " + MultiEssential.getInstance().langConfig.getString("help.commands.trade.command").replace("&", "§"));
                TextComponent vanish = new TextComponent("§7- §6/vanish §7=>" + "§r " + MultiEssential.getInstance().langConfig.getString("help.commands.vanish.command").replace("&", "§"));
                TextComponent whois = new TextComponent("§7- §6/whois §7<§9player§7> =>" + "§r " + MultiEssential.getInstance().langConfig.getString("help.commands.whois.command").replace("&", "§"));
                //TextComponent next = new TextComponent(MultiEssential.getInstance().getConfig().getString("help.next_page").replace("&", "§"));
                TextComponent back = new TextComponent(MultiEssential.getInstance().langConfig.getString("help.previous_page").replace("&", "§"));

                lightning.setBold(true);
                list.setBold(true);
                midday.setBold(true);
                midnight.setBold(true);
                msg.setBold(true);
                night.setBold(true);
                nick.setBold(true);
                r.setBold(true);
                reload.setBold(true);
                setspawn.setBold(true);
                spawn.setBold(true);
                kill.setBold(true);
                time.setBold(true);
                tnt.setBold(true);
                trade.setBold(true);
                vanish.setBold(true);
                whois.setBold(true);
                //next.setBold(true);
                back.setBold(true);

                lightning.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder(MultiEssential.getInstance().langConfig.getString("help.commands.lightning.hover").replace("&", "§")).create()));
                list.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder(MultiEssential.getInstance().langConfig.getString("help.commands.list.hover").replace("&", "§")).create()));
                midday.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder(MultiEssential.getInstance().langConfig.getString("help.commands.midday.hover").replace("&", "§")).create()));
                midnight.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder(MultiEssential.getInstance().langConfig.getString("help.commands.midnight.hover").replace("&", "§")).create()));
                msg.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder(MultiEssential.getInstance().langConfig.getString("help.commands.msg.hover").replace("&", "§")).create()));
                night.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder(MultiEssential.getInstance().langConfig.getString("help.commands.night.hover").replace("&", "§")).create()));
                nick.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder(MultiEssential.getInstance().langConfig.getString("help.commands.nick.hover").replace("&", "§")).create()));
                r.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder(MultiEssential.getInstance().langConfig.getString("help.commands.r.hover").replace("&", "§")).create()));
                reload.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder(MultiEssential.getInstance().langConfig.getString("help.commands.reload.hover").replace("&", "§")).create()));
                setspawn.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder(MultiEssential.getInstance().langConfig.getString("help.commands.setspawn.hover").replace("&", "§")).create()));
                spawn.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder(MultiEssential.getInstance().langConfig.getString("help.commands.spawn.hover").replace("&", "§")).create()));
                kill.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder(MultiEssential.getInstance().langConfig.getString("help.commands.suicide.hover").replace("&", "§")).create()));
                time.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder(MultiEssential.getInstance().langConfig.getString("help.commands.time.hover").replace("&", "§")).create()));
                tnt.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder(MultiEssential.getInstance().langConfig.getString("help.commands.tnt.hover").replace("&", "§")).create()));
                trade.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder(MultiEssential.getInstance().langConfig.getString("help.commands.trade.hover").replace("&", "§")).create()));
                vanish.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder(MultiEssential.getInstance().langConfig.getString("help.commands.vanish.hover").replace("&", "§")).create()));
                whois.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder(MultiEssential.getInstance().langConfig.getString("help.commands.whois.hover").replace("&", "§")).create()));
                //next.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder(MultiEssential.getInstance().getConfig().getString("help.next_page").replace("&", "§")).create()));
                back.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder(MultiEssential.getInstance().langConfig.getString("help.previous_page").replace("&", "§")).create()));

                lightning.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/lightning"));
                list.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/list"));
                midday.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/midday"));
                midnight.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/midnight"));
                msg.setClickEvent(new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, "/msg <message>"));
                night.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/night"));
                nick.setClickEvent(new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, "/nick <nickname>"));
                r.setClickEvent(new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, "/r <message>"));
                reload.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/me reload"));
                setspawn.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/setspawn"));
                kill.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/suicide"));
                spawn.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/spawn"));
                time.setClickEvent(new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, "/time set <ticks>"));
                tnt.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/tnt"));
                trade.setClickEvent(new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, "/trade <player>"));
                vanish.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/vanish"));
                whois.setClickEvent(new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, "/whois <player>"));
                //next.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/me help 3"));
                back.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/me help"));

                player.sendMessage("§a§m-+---------------+- §7 - §e§l{ §6MultiEssential §7- §2[page 2] §e§l} §7- §a§m-+---------------+-");
                player.spigot().sendMessage(lightning);
                player.spigot().sendMessage(list);
                player.spigot().sendMessage(midday);
                player.spigot().sendMessage(midnight);
                player.spigot().sendMessage(msg);
                player.spigot().sendMessage(night);
                player.spigot().sendMessage(nick);
                player.spigot().sendMessage(r);
                player.spigot().sendMessage(reload);
                player.spigot().sendMessage(setspawn);
                player.spigot().sendMessage(spawn);
                player.spigot().sendMessage(kill);
                player.spigot().sendMessage(time);
                player.spigot().sendMessage(tnt);
                player.spigot().sendMessage(trade);
                player.spigot().sendMessage(vanish);
                player.spigot().sendMessage(whois);
                //player.spigot().sendMessage(next);
                player.spigot().sendMessage(back);
                player.sendMessage("§a§m-+----------------------------------------------------------------+-");
            }
        }return false;
    }
}
