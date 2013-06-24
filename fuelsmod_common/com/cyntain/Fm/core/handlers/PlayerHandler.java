package com.cyntain.Fm.core.handlers;

import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentHashMap;

import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.common.FakePlayer;

import com.cyntain.Fm.core.FmPlayerStats;
import com.cyntain.Fm.item.ItemZeoliteVial;

import cpw.mods.fml.common.IPlayerTracker;


/**
 * Tracks players login to a world, log out or switch dimension
 * 
 * @author Cyntain
 */

public class PlayerHandler implements IPlayerTracker {

    public static boolean                           e0;

    public static boolean                           e1;

    public static boolean                           e2;

    public static boolean                           e3;

    public static boolean                           e4;

    public ConcurrentHashMap<String, FmPlayerStats> playerStats = new ConcurrentHashMap<String, FmPlayerStats>();

    @Override
    public void onPlayerLogin(EntityPlayer entityplayer) {

        FmPlayerStats stats = getPlayerStats(entityplayer.username);
        stats.player = new WeakReference<EntityPlayer>(entityplayer);

        NBTTagCompound tags = entityplayer.getEntityData();
        if (!tags.hasKey("FM")) {
            tags.setCompoundTag("FM", new NBTTagCompound());
        }
        for (int i = 0; i < 5; ++i) {

            if (!tags.hasKey("Effect" + i)) {
                tags.setCompoundTag("Effect" + i, new NBTTagCompound());
            System.out.println(i);    
            }

            stats.vial1 = tags.getCompoundTag("Effect1").getBoolean("V1");
            stats.vial2 = tags.getCompoundTag("Effect2").getBoolean("V2");
            stats.vial3 = tags.getCompoundTag("Effect3").getBoolean("V3");
            stats.vial4 = tags.getCompoundTag("Effect4").getBoolean("V4");
            stats.vial5 = tags.getCompoundTag("Effect5").getBoolean("V5");
        }
        if (ItemZeoliteVial.getEffectState(0) == true) {
            tags.getCompoundTag("Effect0").setBoolean("v1", true);
        } else if (ItemZeoliteVial.getEffectState(1) == true) {
            tags.getCompoundTag("Effect1").setBoolean("v2", true);
        } else if (ItemZeoliteVial.getEffectState(2) == true) {
            tags.getCompoundTag("Effect2").setBoolean("v3", true);
        } else if (ItemZeoliteVial.getEffectState(3) == true) {
            tags.getCompoundTag("Effect3").setBoolean("v4", true);
        } else {
            tags.getCompoundTag("Effect4").setBoolean("v5", true);
        }

        playerStats.put(entityplayer.username, stats);
    }

    @Override
    public void onPlayerLogout(EntityPlayer entityplayer) {

        if (entityplayer != null) {
            getPlayerStats(entityplayer.username);
            playerStats.remove(entityplayer.username);
        }
    }

    @Override
    public void onPlayerChangedDimension(EntityPlayer player) {

        // NULL
    }

    @Override
    public void onPlayerRespawn(EntityPlayer entityplayer) {

        FmPlayerStats stats = getPlayerStats(entityplayer.username);
        NBTTagCompound tTag = new NBTTagCompound();
        tTag.setBoolean("Effect0", stats.vial1);
        tTag.setBoolean("Effect1", stats.vial2);
        tTag.setBoolean("Effect2", stats.vial3);
        tTag.setBoolean("Effect3", stats.vial4);
        tTag.setBoolean("Effect4", stats.vial5);
    }

    public FmPlayerStats getPlayerStats(String username) {

        FmPlayerStats stats = playerStats.get(username);
        if (stats == null) {
            stats = new FmPlayerStats();
            playerStats.put(username, stats);
        }
        return stats;
    }

    public static void spawnItemAtPlayer(EntityPlayer player, ItemStack stack) {

        EntityItem entityitem = new EntityItem(player.worldObj, player.posX + 0.5D,
                player.posY + 0.5D, player.posZ + 0.5D, stack);
        player.worldObj.spawnEntityInWorld(entityitem);
        if (!(player instanceof FakePlayer))
            entityitem.onCollideWithPlayer(player);
    }

    public static boolean getDiscEffectState(EntityPlayer entityplayer, int Meta) {

        // FmPlayerStats stats = getPlayerStats(entityplayer.username);
        NBTTagCompound tTag = new NBTTagCompound();
        if (Meta > 5) {
            Meta = 5;
        }
        switch (Meta) {
            case 0:
                e0 = tTag.getBoolean("Effect0");
                return e0;
            case 1:
                e1 = tTag.getBoolean("Effect1");
                return e1;
            case 2:
                e2 = tTag.getBoolean("Effect2");
                return e2;
            case 3:
                e3 = tTag.getBoolean("Effect3");
                return e3;
            case 4:
                e4 = tTag.getBoolean("Effect4");
                return e4;
            default:
                return false;
        }
    }

}
