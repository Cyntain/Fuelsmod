package com.cyntain.Fm.core.handlers;

import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentHashMap;

import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.common.FakePlayer;

import com.cyntain.Fm.core.FmPlayerStats;
import com.cyntain.Fm.lib.Colours;
import com.cyntain.Fm.lib.Reference;

import cpw.mods.fml.common.IPlayerTracker;


/**
 * Tracks players login to a world, log out or switch dimension
 * 
 * @author Cyntain
 */

public class PlayerHandler implements IPlayerTracker {

    public ConcurrentHashMap<String, FmPlayerStats> playerStats = new ConcurrentHashMap<String, FmPlayerStats>();

    @Override
    public void onPlayerLogin(EntityPlayer entityplayer) {

        FmPlayerStats stats = getPlayerStats(entityplayer.username);
        stats.player = new WeakReference<EntityPlayer>(entityplayer);

        NBTTagCompound tags = entityplayer.getEntityData();
        if (!tags.hasKey("FM")) {
            tags.setCompoundTag("FM", new NBTTagCompound());
        }
        stats.Login = tags.getCompoundTag("FM").getBoolean("loggedin");
        if (!stats.Login) {
            tags.getCompoundTag("FM").setBoolean("loggedin", true);
            entityplayer
                    .sendChatToPlayer(Colours.GOLD + "[" + Reference.MOD_NAME + "]" + Colours.WHITE + " Welcome to FuelsMod! If you are new to the mod, please read the wiki! Please check for updates.");
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
        tTag.setBoolean("FM", stats.Login);
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

}
