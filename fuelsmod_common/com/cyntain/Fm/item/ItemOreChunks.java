package com.cyntain.Fm.item;

import java.util.List;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.util.MathHelper;

import com.cyntain.Fm.creativetab.CreativeTabFm;
import com.cyntain.Fm.lib.Reference;
import com.cyntain.Fm.lib.Strings;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;


public class ItemOreChunks extends ItemFm {

    private static final String[] CHUNK_NAMES = new String[]{ "beryllium" , "copper" , "osmium" };

    @SideOnly(Side.CLIENT)
    private Icon[]                icons;

    public ItemOreChunks(int id) {

        super(id);
        this.setHasSubtypes(true);
        this.setUnlocalizedName(Strings.ORE_CHUNK);
        this.setCreativeTab(CreativeTabFm.tabsFuelMod);
        this.maxStackSize = 64;
    }

    @Override
    public String getUnlocalizedName(ItemStack itemstack) {

        int meta = MathHelper.clamp_int(itemstack.getItemDamage(), 0, 3);
        return super.getUnlocalizedName() + CHUNK_NAMES[meta];
    }

    @Override
    @SideOnly(Side.CLIENT)
    public Icon getIconFromDamage(int meta) {

        int j = MathHelper.clamp_int(meta, 0, 5);
        return icons[j];
    }

    
    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister iconregister) {

        icons = new Icon[CHUNK_NAMES.length];

        for (int i = 0; i < CHUNK_NAMES.length; ++i) {
            icons[i] = iconregister.registerIcon(Reference.MOD_ID.toLowerCase() + ":"
                    + Strings.ORE_CHUNK + CHUNK_NAMES[i]);
        }

    }

    @SuppressWarnings({ "unchecked" , "rawtypes" })
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean par4) {

        int meta = MathHelper.clamp_int(itemStack.getItemDamage(), 0, 3);

        switch (meta) {
            case 0:
                list.add("Be");
                break;
            case 1:
                list.add("Cu");
                break;
            case 2:
                list.add("Os");
                break;
            default:
                list.add("UNKNOWN");
                break;
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
