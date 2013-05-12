
package com.cyntain.Fm.core.proxy;


import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;

import com.cyntain.Fm.Client.gui.containerMixingTable;
import com.cyntain.Fm.Client.gui.guiMixingTable;
import com.cyntain.Fm.TileEntity.tileMixingTable;
import com.cyntain.Fm.lib.GUIIDs;
import com.cyntain.Fm.lib.Strings;

import cpw.mods.fml.common.network.IGuiHandler;
import cpw.mods.fml.common.registry.GameRegistry;




public class CommonProxy implements IGuiHandler {

    public void registerRenders() {

    }

    public void registerTileEntities() {

        GameRegistry.registerTileEntity(tileMixingTable.class,
                Strings.TE_MIXINGTABLE);
    }

    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world,
            int x, int y, int z) {

        if (ID == GUIIDs.mixingTable) {
            tileMixingTable mixingtable = (tileMixingTable) world
                    .getBlockTileEntity(x, y, z);

            return new containerMixingTable(player.inventory, mixingtable);

        }
        return null;

    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world,
            int x, int y, int z) {

        if (ID == GUIIDs.mixingTable) {
            tileMixingTable mixingtable = (tileMixingTable) world
                    .getBlockTileEntity(x, y, z);

            return new guiMixingTable(player.inventory, mixingtable);

        }
        return null;
    }

    public void handleTileEntityPacket(int x, int y, int z,
            ForgeDirection orientation, byte state, String customName) {

    }
}
