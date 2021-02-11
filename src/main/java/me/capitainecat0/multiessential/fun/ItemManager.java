package me.capitainecat0.multiessential.fun;

import me.capitainecat0.multiessential.MultiEssential;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class ItemManager {

    public static ItemStack lightning;
    public static ItemStack kb;
    public static ItemStack tnt;
    public static ItemStack porte;

    public static void lightning(){lightningStick();}
    public static void kb() { KnockbackStick(); }
    public static void tnt(){Tnt();}
    public static void porte(){LePorte();}

    private static void lightningStick(){
        ItemStack item = new ItemStack(Material.STICK);
        ItemMeta meta = item.getItemMeta();
        item.setAmount(1);
        List<String> lore = new ArrayList<>(MultiEssential.getInstance().itemsConfig.getStringList("lightning.item.lore"));
        meta.setDisplayName(MultiEssential.getInstance().formatText(MultiEssential.getInstance().itemsConfig.getString("lightning.item.displayname")));
        meta.setLore(lore);
        if(MultiEssential.getInstance().itemsConfig.getBoolean("lightning.item.glowing")){
            meta.addEnchant(Enchantment.LUCK, 1, false);
        }
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.setItemMeta(meta);
        lightning = item;
    }

    private static void KnockbackStick(){
        ItemStack item = new ItemStack(Material.STICK);
        ItemMeta meta = item.getItemMeta();
        item.setAmount(1);
        List<String> lore = new ArrayList<>(MultiEssential.getInstance().itemsConfig.getStringList("kbstick.item.lore"));
        meta.setDisplayName(MultiEssential.getInstance().formatText(MultiEssential.getInstance().itemsConfig.getString("kbstick.item.displayname")));
        meta.setLore(lore);
        meta.addEnchant(Enchantment.KNOCKBACK, MultiEssential.getInstance().itemsConfig.getInt("kbstick.item.level"), true);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.setItemMeta(meta);
        kb = item;
    }

    private static void Tnt(){
        ItemStack item = new ItemStack(Material.STICK);
        ItemMeta meta = item.getItemMeta();
        item.setAmount(1);
        List<String> lore = new ArrayList<>(MultiEssential.getInstance().itemsConfig.getStringList("tnt.item.lore"));
        meta.setDisplayName(MultiEssential.getInstance().formatText(MultiEssential.getInstance().itemsConfig.getString("tnt.item.displayname")));
        meta.setLore(lore);
        if(MultiEssential.getInstance().itemsConfig.getBoolean("tnt.item.glowing")){
            meta.addEnchant(Enchantment.LUCK, 1, false);
        }
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.setItemMeta(meta);
        tnt = item;
    }

    private static void LePorte(){
        ItemStack item = new ItemStack(Material.OAK_DOOR);
        ItemMeta meta = item.getItemMeta();
        item.setAmount(1);
        meta.setDisplayName("§e§lLePorte");
        meta.setLore(Collections.singletonList("El famoso Porte"));
        meta.setLore(Collections.singletonList("(the french touch of Essentials)"));
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, new AttributeModifier("generic.attack.damage", 666, AttributeModifier.Operation.ADD_NUMBER));
        meta.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, new AttributeModifier("generic.movement.speed", 1, AttributeModifier.Operation.ADD_NUMBER));
        meta.addEnchant(Enchantment.LUCK, 1, false);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        meta.addItemFlags(ItemFlag.HIDE_PLACED_ON);
        item.setItemMeta(meta);
        porte = item;
    }
}
