
package com.cyntain.Fm.CreativeTab;


import com.cyntain.Fm.Item.ModItem;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import net.minecraft.creativetab.CreativeTabs;




public final class CreativeTabFmAlchemy extends CreativeTabs {
    public CreativeTabFmAlchemy() {

        super("Fuels Mod: Alchemy");
    }

    @SideOnly(Side.CLIENT)
    @Override
    public String getTranslatedTabLabel() {

        return getTabLabel();
    }

    @SideOnly(Side.CLIENT)
    @Override
    public int getTabIconItemIndex() {

        return ModItem.emptyVial.itemID;
    }

    public static final CreativeTabs tabsFuelsmodAlchemy = new CreativeTabFmAlchemy();

}