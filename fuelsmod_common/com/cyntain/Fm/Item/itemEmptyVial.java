package com.cyntain.Fm.Item;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

import com.cyntain.Fm.CreativeTab.CreativeTabFmAlchemy;
import com.cyntain.Fm.lib.Strings;

public class itemEmptyVial extends ItemFm {
   public itemEmptyVial(int id){
       super(id);
       setUnlocalizedName(Strings.EMPTY_VIAL_NAME);
       setCreativeTab(CreativeTabFmAlchemy.tabsFuelsmodAlchemy);
   }
   @SuppressWarnings({ "unchecked", "rawtypes" })
	public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean par){  
   	list.add("A vial (also known as a phial or flacon)");
   }
}
