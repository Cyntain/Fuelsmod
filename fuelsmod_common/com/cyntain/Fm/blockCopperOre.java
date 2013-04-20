package com.cyntain.Fm;

import com.cyntain.Fm.CreativeTab.CreativeTabFm;
//import com.cyntain.Fm.lib.Reference;

//import cpw.mods.fml.relauncher.Side;
//import cpw.mods.fml.relauncher.SideOnly;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
//import net.minecraft.client.renderer.texture.IconRegister;

        public class blockCopperOre extends Block {
    
                public blockCopperOre(int id, Material par2Material){
                        super(id, par2Material);
                            this.setCreativeTab(CreativeTabFm.tabsFuelMod);
   }
                /*
                @SideOnly(Side.CLIENT)
                public void registerIcons(IconRegister iconRegister) {
                    this.blockIcon = iconRegister.registerIcon(Reference.MOD_ID + ":" + this.getUnlocalizedName2());
            }
*/
}
