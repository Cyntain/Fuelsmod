package com.cyntain.Fm.Block;

import java.util.Random;

import com.cyntain.Fm.CreativeTab.CreativeTabFm;
import com.cyntain.Fm.lib.Strings;
import com.cyntain.Fm.tileEntity.TileEntityMultiSmelterCore;
import com.cyntain.Fm.tileEntity.TileEntityMultiSmelterDummy;


import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;

import net.minecraft.client.renderer.texture.IconRegister;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;

import net.minecraft.world.World;

public class blockMultiSmelterDummy extends BlockContainer {
    public blockMultiSmelterDummy(int id){
        super(id, Material.rock);
        setUnlocalizedName(Strings.SMELTER_DUMMY);
        setStepSound(Block.soundStoneFootstep);
        setHardness(3.5f);
        setCreativeTab(CreativeTabFm.tabsFuelMod);
    }
    @Override
    public int idDropped(int par1, Random par2Random, int par3)
    {
        return ModBlock.heatproofBrickBlock.blockID;
    }
    
    @Override
    public TileEntity createNewTileEntity(World world)
    {
        return new TileEntityMultiSmelterDummy();
    }
    
    @Override
    public void registerIcons(IconRegister iconRegister)
    {
        blockIcon = iconRegister.registerIcon("Fm:heatproofBrickBlock");
    }
    
    @Override
    public void breakBlock(World world, int x, int y, int z, int par5, int par6)
    {
        TileEntityMultiSmelterDummy dummy = (TileEntityMultiSmelterDummy)world.getBlockTileEntity(x, y, z);
        
        if(dummy != null && dummy.getCore() != null)
            dummy.getCore().invalidateMultiblock();
        
        super.breakBlock(world, x, y, z, par5, par6);
    }
    
    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int par6, float par7, float par8, float par9)
    {
        if(player.isSneaking())
            return false;
        
        TileEntityMultiSmelterDummy dummy = (TileEntityMultiSmelterDummy)world.getBlockTileEntity(x, y, z);
        
        if(dummy != null && dummy.getCore() != null)
        {
            TileEntityMultiSmelterCore core = dummy.getCore();
            return core.getBlockType().onBlockActivated(world, core.xCoord, core.yCoord, core.zCoord, player, par6, par7, par8, par9);
        }
        
        return true;
    }
}