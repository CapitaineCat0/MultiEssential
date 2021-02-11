package me.capitainecat0.multiessential.fun.commands;

import me.capitainecat0.multiessential.MultiEssential;
import me.capitainecat0.multiessential.fun.items.Knockback;
import me.capitainecat0.multiessential.fun.items.LePorte;
import me.capitainecat0.multiessential.fun.items.Lightning;
import me.capitainecat0.multiessential.fun.items.Tnt;
import me.capitainecat0.multiessential.moderation.commands.Nick;

public class FunCommands {
    public void init(){
        MultiEssential.getInstance().getCommand("kbstick").setExecutor(new Knockback(MultiEssential.getInstance()));
        MultiEssential.getInstance().getCommand("lightning").setExecutor(new Lightning(MultiEssential.getInstance()));
        MultiEssential.getInstance().getCommand("tnt").setExecutor(new Tnt(MultiEssential.getInstance()));
        MultiEssential.getInstance().getCommand("leporte").setExecutor(new LePorte());
        MultiEssential.getInstance().getCommand("nick").setExecutor(new Nick(MultiEssential.getInstance()));
        MultiEssential.getInstance().getCommand("hat").setExecutor(new Hat(MultiEssential.getInstance()));
    }
}
