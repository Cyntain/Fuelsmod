package com.cyntain.Fm.Block;

import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.util.Icon;

import com.cyntain.Fm.CreativeTab.CreativeTabFm;
import com.cyntain.Fm.lib.Reference;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
/**
 * Multiple textures that are displayed, please use this code on the other tables! thanks
 * */
public class BlockMixingTable extends BlockFm {
    
    public final String[] FACES = new String[] { "top", "bottom", "side" };
    @SideOnly(Side.CLIENT)
    private Icon[] icons;


    public BlockMixingTable(int id, Material material) {

        super(id, material);
        this.setCreativeTab(CreativeTabFm.tabsFuelMod);
        this.setHardness(5f);

    }
        
    
    @SideOnly(Side.CLIENT)
    public Icon sides, bottom, top;
   
    //Textures
    @SideOnly(Side.CLIENT)
    
public void registerIcons(IconRegister iconregister)
{    
        this.bottom = iconregister.registerIcon(Reference.MOD_ID + ":" + this.getUnlocalizedName2() + "_" + FACES[0]);
        this.top = iconregister.registerIcon(Reference.MOD_ID + ":" + this.getUnlocalizedName2() + "_" + FACES[1]);
        this.sides =  iconregister.registerIcon(Reference.MOD_ID + ":" + this.getUnlocalizedName2() + "_" + FACES[2]);    
}
        



@SideOnly(Side.CLIENT)
public Icon getBlockTextureFromSideAndMetadata(int side, int meta)
{
    if(side == 0){
        return top;}
    else if (side == 1){
        return bottom;}
    else {
        return sides; }
    }
}
   
    
    
