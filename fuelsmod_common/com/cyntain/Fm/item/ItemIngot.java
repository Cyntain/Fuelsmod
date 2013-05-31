package com.cyntain.Fm.item;

import java.util.List;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.util.MathHelper;

import com.cyntain.Fm.creativetab.CreativeTabFm;
//import com.cyntain.Fm.creativetab.CreativeTabFm;
import com.cyntain.Fm.lib.Reference;
import com.cyntain.Fm.lib.Strings;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;


public class ItemIngot extends ItemFm {

    public static final String[] INGOTS_NAMES = { "Copper" , "Beryllium" , "Osmium" };

    @SideOnly(Side.CLIENT)
    private Icon[]               icons;

    public ItemIngot(int id) {

        super(id);
        this.setUnlocalizedName(Strings.INGOT_NAME);
        this.setHasSubtypes(true);   
        this.setCreativeTab(CreativeTabFm.tabsFuelMod);
        this.setMaxStackSize(64);
    }


    @Override
    public String getUnlocalizedName(ItemStack itemstack) {

        int meta = MathHelper.clamp_int(itemstack.getItemDamage(), 0, 2);
        return super.getUnlocalizedName() + INGOTS_NAMES[meta];
    }

    @Override
    @SideOnly(Side.CLIENT)
    public Icon getIconFromDamage(int meta) {

        int j = MathHelper.clamp_int(meta, 0, 2);
        return icons[j];
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister iconregister) {

        icons = new Icon[INGOTS_NAMES.length];

        for (int i = 0; i < INGOTS_NAMES.length; ++i) {
            icons[i] = iconregister.registerIcon(Reference.MOD_ID.toLowerCase() + ":"
                     + INGOTS_NAMES[i].toLowerCase() + "Ingot");
        }

    }

    @Override
    @SuppressWarnings({ "unchecked" , "rawtypes" })
    @SideOnly(Side.CLIENT)
    public void getSubItems(int id, CreativeTabs creativeTab, List list) {

        for (int meta = 0; meta < 3; ++meta) {
            list.add(new ItemStack(id, 1, meta));
        }
    }
}