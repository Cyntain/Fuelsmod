package com.cyntain.Fm.Block;

import com.cyntain.Fm.CreativeTab.CreativeTabFm;
import com.cyntain.Fm.lib.Reference;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;

    public abstract class BlockFm extends BlockContainer {
     public BlockFm(int id, Material material) {
         super(id, material);
         setCreativeTab(CreativeTabFm.tabsFuelMod);
         
     }
//Load textures
@SideOnly(Side.CLIENT)
     public void updateIcons(IconRegister iconRegister) {
                     this.blockIcon = iconRegister.registerIcon(Reference.MOD_ID + ":" + this.getUnlocalizedName2());
     }
    
    
    
    
}
