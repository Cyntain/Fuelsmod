package com.cyntain.Fm.CreativeTab;
 

import com.cyntain.Fm.Item.ModItem;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import net.minecraft.creativetab.CreativeTabs;
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
    public final class CreativeTabFm extends CreativeTabs{
  public CreativeTabFm(){
      super("Fuels Mod");
      }
@SideOnly(Side.CLIENT)
@Override
  public String getTranslatedTabLabel(){
      return getTabLabel();
  }
@SideOnly(Side.CLIENT)
@Override
  public int getTabIconItemIndex(){
      return ModItem.ChunkCopper.itemID;
  }
  
  public static final CreativeTabs tabsFuelMod = new CreativeTabFm();
  
  
}