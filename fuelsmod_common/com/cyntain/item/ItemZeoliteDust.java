package com.cyntain.Fm.item;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

import com.cyntain.Fm.creativetab.CreativeTabFm;
import com.cyntain.Fm.lib.Strings;


public class ItemZeoliteDust extends ItemFm {

    public ItemZeoliteDust(int id) {

        super(id);
        this.setUnlocalizedName(Strings.ZEOLITE_DUST_NAME);
        setCreativeTab(CreativeTabFm.tabsFuelMod);
    }

    @SuppressWarnings({ "unchecked" , "rawtypes" })
    public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean par4) {

        list.add("Na12 (Al12 Si12 O48)27 H2O");
    }
}