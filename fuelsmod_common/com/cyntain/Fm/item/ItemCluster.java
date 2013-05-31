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


public class ItemCluster extends ItemFm {

    public static final String[] CLUSTER_NAME = { "Beryllium" , "Copper" };
    @SideOnly(Side.CLIENT)
    private Icon[]               icons;

    public ItemCluster(int id) {

        super(id);
        this.setHasSubtypes(true);
        this.setCreativeTab(CreativeTabFm.tabsFuelMod);
        this.setUnlocalizedName(Strings.CLUSTER_NAME);

    }

    @Override
    public String getUnlocalizedName(ItemStack itemstack) {

        int meta = MathHelper.clamp_int(itemstack.getItemDamage(), 0, 1);
       // System.out.println(meta + super.getUnlocalizedName());
        return super.getUnlocalizedName() + CLUSTER_NAME[meta];
    }

    @Override
    @SideOnly(Side.CLIENT)
    public Icon getIconFromDamage(int meta) {

        int j = MathHelper.clamp_int(meta, 0, 1);
        return icons[j];
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister iconregister) {

        icons = new Icon[CLUSTER_NAME.length];

        for (int i = 0; i < CLUSTER_NAME.length; ++i) {
            icons[i] = iconregister.registerIcon(Reference.MOD_ID.toLowerCase() + ":"
                    + Strings.CLUSTER_NAME + CLUSTER_NAME[i]);
        }

    }

    @Override
    @SuppressWarnings({ "unchecked" , "rawtypes" })
    @SideOnly(Side.CLIENT)
    public void getSubItems(int id, CreativeTabs creativeTab, List list) {

        for (int meta = 0; meta < 2; ++meta) {
            list.add(new ItemStack(id, 1, meta));
        }
    }
}
