package com.cyntain.Fm.item;

import java.util.List;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.util.MathHelper;

import com.cyntain.Fm.creativetab.CreativeTabFm;
import com.cyntain.Fm.lib.Reference;
import com.cyntain.Fm.lib.Strings;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;


public class ItemCog extends ItemFm {

    public static final String[] COG_NAME = new String[]{ "Wood" , "Stone" , "Iron", "Copper" };

    @SideOnly(Side.CLIENT)
    private Icon[]               icons;

    public ItemCog(int id) {

        super(id);
        this.setHasSubtypes(true);
        this.setUnlocalizedName(Strings.COG_NAME);
        setCreativeTab(CreativeTabFm.tabsFuelMod);
    }

    @Override
    public String getUnlocalizedName(ItemStack itemstack) {

        int meta = MathHelper.clamp_int(itemstack.getItemDamage(), 0, 3);
        return super.getUnlocalizedName() + COG_NAME[meta];
    }

    @Override
    @SideOnly(Side.CLIENT)
    public Icon getIconFromDamage(int meta) {

        int j = MathHelper.clamp_int(meta, 0, 3);
        return icons[j];
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister iconregister) {

        icons = new Icon[COG_NAME.length];

        for (int i = 0; i < COG_NAME.length; ++i) {
            icons[i] = iconregister.registerIcon(Reference.MOD_ID + ":" + Strings.COG_NAME
                    + COG_NAME[i]);
        }
    }

    @Override
    @SuppressWarnings({ "unchecked" , "rawtypes" })
    @SideOnly(Side.CLIENT)
    public void getSubItems(int id, CreativeTabs creativeTab, List list) {

        for (int meta = 0; meta < 5; ++meta) {
            list.add(new ItemStack(id, 1, meta));
        }
    }
}
