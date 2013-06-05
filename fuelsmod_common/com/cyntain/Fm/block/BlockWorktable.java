package com.cyntain.Fm.block;

import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import com.cyntain.Fm.FuelsMod;
import com.cyntain.Fm.lib.GUIIDs;
import com.cyntain.Fm.lib.Strings;
import com.cyntain.Fm.tileentity.TileWorkTable;


public class BlockWorktable extends BlockFm implements ITileEntityProvider{

    public BlockWorktable(int id, Material material) {

        super(id, material);
        setUnlocalizedName(Strings.WORKTABLE_BLOCK);
        setHardness(5F);

    }
    @Override
    public TileEntity createNewTileEntity(World world) {

        return new TileWorkTable();
    }
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player,
            int par6, float par7, float par8, float par9) {

        if (player.isSneaking())
            return false;

        else {
            if (!world.isRemote) {
               TileWorkTable worktable = (TileWorkTable) world.getBlockTileEntity(x, y, z);

                if (worktable != null) {
                    System.out.println("SHOULD WORK");
                    player.openGui(FuelsMod.instance, GUIIDs.workTable, world, x, y, z);
                }
            }
        }
        return true;

    }
}
