package me.capitainecat0.multiessential.commands;

import me.capitainecat0.multiessential.MultiEssential;

public class MultiCommands {
    public void init(){
        MultiEssential.getInstance().getCommand("alert").setExecutor(new Alert(MultiEssential.getInstance()));
        //MultiEssential.getInstance().getCommand("bal").setExecutor(new Economy(MultiEssential.getInstance()));
        //MultiEssential.getInstance().getCommand("balance").setExecutor(new Economy(MultiEssential.getInstance()));
        MultiEssential.getInstance().getCommand("bc").setExecutor(new Alert(MultiEssential.getInstance()));
        MultiEssential.getInstance().getCommand("broadcast").setExecutor(new Alert(MultiEssential.getInstance()));
        MultiEssential.getInstance().getCommand("craft").setExecutor(new Craft());
        MultiEssential.getInstance().getCommand("ec").setExecutor(new EnderChest(MultiEssential.getInstance()));
        //MultiEssential.getInstance().getCommand("eco").setExecutor(new Economy(MultiEssential.getInstance()));
        MultiEssential.getInstance().getCommand("enderchest").setExecutor(new EnderChest(MultiEssential.getInstance()));
        MultiEssential.getInstance().getCommand("feed").setExecutor(new Feed(MultiEssential.getInstance()));
        MultiEssential.getInstance().getCommand("heal").setExecutor(new Heal(MultiEssential.getInstance()));
        MultiEssential.getInstance().getCommand("help").setExecutor(new MeHelp_1(MultiEssential.getInstance()));
        MultiEssential.getInstance().getCommand("list").setExecutor(new List(MultiEssential.getInstance()));
        MultiEssential.getInstance().getCommand("me").setExecutor(new MeHelp_1(MultiEssential.getInstance()));
        MultiEssential.getInstance().getCommand("mess").setExecutor(new MeHelp_1(MultiEssential.getInstance()));
        MultiEssential.getInstance().getCommand("multie").setExecutor(new MeHelp_1(MultiEssential.getInstance()));
        //MultiEssential.getInstance().getCommand("money").setExecutor(new Economy(MultiEssential.getInstance()));
        MultiEssential.getInstance().getCommand("reload").setExecutor(new MeHelp_1(MultiEssential.getInstance()));
        MultiEssential.getInstance().getCommand("suicide").setExecutor(new Suicide(MultiEssential.getInstance()));
        MultiEssential.getInstance().getCommand("multiessentialhelppage").setExecutor(new MeHelp_2(MultiEssential.getInstance()));
        MultiEssential.getInstance().getCommand("msg").setExecutor(new PrivateMsg(MultiEssential.getInstance()));
        MultiEssential.getInstance().getCommand("trade").setExecutor(new Trade(MultiEssential.trade));
        MultiEssential.getInstance().getCommand("w").setExecutor(new PrivateMsg(MultiEssential.getInstance()));
        MultiEssential.getInstance().getCommand("workbench").setExecutor(new Craft());
        MultiEssential.getInstance().getCommand("r").setExecutor(new PrivateMsg(MultiEssential.getInstance()));
        MultiEssential.getInstance().getCommand("spawn").setExecutor(new Spawn(MultiEssential.getInstance()));
    }
}
