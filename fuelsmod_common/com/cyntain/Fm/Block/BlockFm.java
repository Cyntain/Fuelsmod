package com.cyntain.Fm.Block;

import com.cyntain.Fm.CreativeTab.CreativeTabFm;
import com.cyntain.Fm.lib.Reference;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
/*Fuels Mod
 * 
 * @Authors: Cyntain and Paronamixxe
 * 
 * FuelsMod
 * 
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 * @credit: Visual_Argonian, Pahimar (enim mihi inspirante) and Plenty_of_Fish
 * */
  


    public abstract class BlockFm extends Block {
        
        public BlockFm(int id, Material material) {
         
            super(id, material);
                 setCreativeTab(CreativeTabFm.tabsFuelMod);
                 setStepSound(soundStoneFootstep);
                 setHardness(2.0f);
                 
     }
            //Load textures
@SideOnly(Side.CLIENT)
                 public void updateIcons(IconRegister iconRegister) {
                     this.blockIcon = iconRegister.registerIcon(Reference.MOD_ID + ":" + this.getUnlocalizedName2());
     }
}
