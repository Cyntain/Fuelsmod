
package com.cyntain.Fm.core.proxy;


import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;

import com.cyntain.Fm.client.gui.ContainerMixingTable;
import com.cyntain.Fm.client.gui.GuiMixingTable;
import com.cyntain.Fm.tileentity.TileMixingTable;
import com.cyntain.Fm.lib.GUIIDs;
import com.cyntain.Fm.lib.Strings;

import cpw.mods.fml.common.network.IGuiHandler;
import cpw.mods.fml.common.registry.GameRegistry;




public class CommonProxy implements IGuiHandler {

    public void registerRenders() {

    }

    public void registerTileEntities() {

        GameRegistry.registerTileEntity(TileMixingTable.class,
                Strings.TE_MIXINGTABLE);
    }

    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world,
            int x, int y, int z) {

        if (ID == GUIIDs.mixingTable) {
            TileMixingTable mixingtable = (TileMixingTable) world
                    .getBlockTileEntity(x, y, z);

            return new ContainerMixingTable(player.inventory, mixingtable);

        }
        return null;

    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world,
            int x, int y, int z) {

        if (ID == GUIIDs.mixingTable) {
            TileMixingTable mixingtable = (TileMixingTable) world
                    .getBlockTileEntity(x, y, z);

            return new GuiMixingTable(player.inventory, mixingtable);

        }
        return null;
    }

    public void handleTileEntityPacket(int x, int y, int z,
            ForgeDirection orientation, byte state, String customName) {

    }
}
