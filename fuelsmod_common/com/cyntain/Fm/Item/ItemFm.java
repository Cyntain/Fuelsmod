package com.cyntain.Fm.Item;

import com.cyntain.Fm.lib.Reference;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;



public class ItemFm extends Item {
   
    public ItemFm(int id){
        
        super(id);
           maxStackSize = 64;
               setCreativeTab(CreativeTabs.tabMisc);
    }
    @SideOnly(Side.CLIENT)
    @Override
            public void updateIcons(IconRegister iconRegister) {
                    this.iconIndex = iconRegister.registerIcon(Reference.MOD_ID + ":" + this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(".") + 1) );
      
                    
        }
   }
