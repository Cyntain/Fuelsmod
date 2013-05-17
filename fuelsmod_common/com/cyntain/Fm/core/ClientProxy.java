
package com.cyntain.Fm.core;


import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.ForgeDirection;

import com.cyntain.Fm.tileentity.TileFm;
import com.cyntain.Fm.core.proxy.CommonProxy;

import cpw.mods.fml.client.FMLClientHandler;




public class ClientProxy extends CommonProxy {

    @Override
    public void registerRenders() {

    }

    @Override
    public void handleTileEntityPacket(int x, int y, int z,
            ForgeDirection orientation, byte state, String customName) {

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