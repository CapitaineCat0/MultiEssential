package me.capitainecat0.multiessential.moderation.commands;

import me.capitainecat0.multiessential.MultiEssential;
import me.capitainecat0.multiessential.commands.Spawn;

public class ModCommands {
    public void init(){
        MultiEssential.getInstance().getCommand("admin").setExecutor(new AdminInv(MultiEssential.getInstance()));
        MultiEssential.getInstance().getCommand("ci").setExecutor(new CI(MultiEssential.getInstance()));
        MultiEssential.getInstance().getCommand("clear").setExecutor(new CI(MultiEssential.getInstance()));
        MultiEssential.getInstance().getCommand("clearinv").setExecutor(new CI(MultiEssential.getInstance()));
        MultiEssential.getInstance().getCommand("clearinventory").setExecutor(new CI(MultiEssential.getInstance()));
        MultiEssential.getInstance().getCommand("fly").setExecutor(new Fly(MultiEssential.getInstance()));
        MultiEssential.getInstance().getCommand("freeze").setExecutor(new Freeze(MultiEssential.getInstance()));
        MultiEssential.getInstance().getCommand("gm").setExecutor(new Gamemode(MultiEssential.getInstance()));
        MultiEssential.getInstance().getCommand("gamemode").setExecutor(new Gamemode(MultiEssential.getInstance()));
        MultiEssential.getInstance().getCommand("god").setExecutor(new God(MultiEssential.getInstance()));
        MultiEssential.getInstance().getCommand("invsee").setExecutor(new Invsee(MultiEssential.getInstance()));
        MultiEssential.getInstance().getCommand("setspawn").setExecutor(new Spawn(MultiEssential.getInstance()));
        MultiEssential.getInstance().getCommand("serverinfo").setExecutor(new ServerInfo(MultiEssential.getInstance()));
        MultiEssential.getInstance().getCommand("time").setExecutor(new Time(MultiEssential.getInstance()));
        MultiEssential.getInstance().getCommand("tp").setExecutor(new TP(MultiEssential.getInstance()));
        MultiEssential.getInstance().getCommand("day").setExecutor(new Time(MultiEssential.getInstance()));
        MultiEssential.getInstance().getCommand("midday").setExecutor(new Time(MultiEssential.getInstance()));
        MultiEssential.getInstance().getCommand("midnight").setExecutor(new Time(MultiEssential.getInstance()));
        MultiEssential.getInstance().getCommand("night").setExecutor(new Time(MultiEssential.getInstance()));
        MultiEssential.getInstance().getCommand("nick").setExecutor(new Nick(MultiEssential.getInstance()));
        MultiEssential.getInstance().getCommand("whois").setExecutor(new Whois(MultiEssential.getInstance()));
        MultiEssential.getInstance().getCommand("vanish").setExecutor(new Vanish(MultiEssential.getInstance()));
        MultiEssential.getInstance().getCommand("v").setExecutor(new Vanish(MultiEssential.getInstance()));
    }
}
