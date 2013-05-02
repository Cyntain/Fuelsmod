package com.cyntain.Fm.Item;


import com.cyntain.Fm.lib.Reference;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;
/*Fuels Mod
 * 
 * @Authors: Cyntain and Paronamixxe
 * 
 * FuelsMod
 * 
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 * @credit: Visual_Argonian, Pahimar  and Plenty_of_Fish
 * */


public class ItemFm extends Item {
   
    public ItemFm(int id){
        
        super(id - Reference.SHIFTED_ID_RANGE_CORRECTION);
           maxStackSize = 64;
           setNoRepair();
               
    }
    @SideOnly(Side.CLIENT)
    @Override
            public void updateIcons(IconRegister iconRegister) {
                    this.iconIndex = iconRegister.registerIcon(Reference.MOD_ID + ":" + this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(".") + 1) );
      
                    
        }

   }
