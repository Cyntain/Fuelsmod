package com.cyntain.Fm.item;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

import com.cyntain.Fm.creativetab.CreativeTabFm;
import com.cyntain.Fm.lib.Colours;
import com.cyntain.Fm.lib.Strings;


public class ItemBoiler extends ItemFm {

    public ItemBoiler(int id) {

        super(id);
        this.setUnlocalizedName(Strings.BOILER_NAME);
        setCreativeTab(CreativeTabFm.tabsFuelMod);
    }

    @SuppressWarnings({ "unchecked" , "rawtypes" })
    public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean par4) {

        boolean Information = true;
        list.add(Colours.WHITE + "A device used to create steam ");

        if (Information == true) {
            list.add(Colours.WHITE + "by applying heat energy to water.");
        }
    }
}
