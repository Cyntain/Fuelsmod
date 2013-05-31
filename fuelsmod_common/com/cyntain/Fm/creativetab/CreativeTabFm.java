
package com.cyntain.Fm.creativetab;


import com.cyntain.Fm.item.ModItem;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import net.minecraft.creativetab.CreativeTabs;




public final class CreativeTabFm extends CreativeTabs {
    public CreativeTabFm() {

        super("Fuels Mod");
    }

    @SideOnly(Side.CLIENT)
    @Override
    public String getTranslatedTabLabel() {

        return getTabLabel();
    }

    @SideOnly(Side.CLIENT)
    @Override
    public int getTabIconItemIndex() {

        return ModItem.zeoliteDust.itemID;
    }

    public static final CreativeTabs tabsFuelMod = new CreativeTabFm();

}