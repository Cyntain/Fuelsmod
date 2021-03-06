package com.cyntain.Fm.core;

import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.ForgeDirection;

import com.cyntain.Fm.client.renders.MixingTableRender;
import com.cyntain.Fm.client.renders.TeRenderMixingTable;
import com.cyntain.Fm.core.proxy.CommonProxy;
import com.cyntain.Fm.tileentity.TileFm;
import com.cyntain.Fm.tileentity.TileMixingTable;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;


public class ClientProxy extends CommonProxy {

    public static int MIXINGTABLE;

    @Override
    public void registerTileEntities() {
        ClientRegistry.bindTileEntitySpecialRenderer(TileMixingTable.class,
                new TeRenderMixingTable());
    }

    public void PreInitRenders() {

        MIXINGTABLE = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new MixingTableRender());
    }

    @Override
    public void registerRenders() {

    }

    @Override
    public void handleTileEntityPacket(int x, int y, int z, ForgeDirection orientation, byte state,
            String customName) {

        TileEntity tileEntity = FMLClientHandler.instance().getClient().theWorld
                .getBlockTileEntity(x, y, z);

        if (tileEntity != null) {
            if (tileEntity instanceof TileFm) {
                ((TileFm) tileEntity).setOrientation(orientation);
                ((TileFm) tileEntity).setState(state);
                ((TileFm) tileEntity).setCustomName(customName);
            }
        }

    }
}