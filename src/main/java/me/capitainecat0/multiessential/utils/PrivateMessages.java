package me.capitainecat0.multiessential.utils;

import me.capitainecat0.multiessential.MultiEssential;
import org.bukkit.entity.Player;

import java.util.HashMap;

public class PrivateMessages {
    static HashMap<Player,Player> msg = new HashMap<Player,Player>();
    public PrivateMessages(MultiEssential instance){}

    public static void setReplyTarget(Player msender, Player reciever){
        msg.put(msender, reciever);
        msg.put(reciever, msender);
    }
    public static Player getReplyTarget(Player msender){
        return msg.get(msender);
    }
}
