
package com.cyntain.Fm.Item;


import java.util.List;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.Icon;
import net.minecraft.util.MathHelper;

import com.cyntain.Fm.CreativeTab.CreativeTabFmAlchemy;
import com.cyntain.Fm.lib.Reference;
import com.cyntain.Fm.lib.Strings;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;




/* Alchemy - side project :P*/

public class itemZeoliteDyed extends ItemFm {

    private static final String[] ZEOLITE_DUST_DYED_NAMES = new String[] {
            "reden", "greue", "yellen", "lueel"};

    @SideOnly(Side.CLIENT)
    private Icon[]                icons;

    public itemZeoliteDyed(int id) {

        super(id);
        this.setUnlocalizedName(Strings.ZEOLITE_DYED_NAME);
        this.setCreativeTab(CreativeTabFmAlchemy.tabsFuelsmodAlchemy);
        setHasSubtypes(true);
        maxStackSize = 64;
    }

    @Override
    public String getUnlocalizedName(ItemStack itemstack) {

        int meta = MathHelper.clamp_int(itemstack.getItemDamage(), 0, 3);
        return super.getUnlocalizedName() + ZEOLITE_DUST_DYED_NAMES[meta];
    }

    @Override
    @SideOnly(Side.CLIENT)
    public Icon getIconFromDamage(int meta) {

        int j = MathHelper.clamp_int(meta, 0, 5);
        return icons[j];
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void updateIcons(IconRegister iconregister) {

        icons = new Icon[ZEOLITE_DUST_DYED_NAMES.length];

        for (int i = 0; i < ZEOLITE_DUST_DYED_NAMES.length; ++i) {
            icons[i] = iconregister.registerIcon(Reference.MOD_ID.toLowerCase()
                    + ":" + Strings.ZEOLITE_DYED_NAME + "_"
                    + ZEOLITE_DUST_DYED_NAMES[i]);
        }

    }

    @Override
    public String getItemDisplayName(ItemStack itemStack) {

        int meta = MathHelper.clamp_int(itemStack.getItemDamage(), 0, 3);

        switch (meta) {
            case 0:
                return EnumChatFormatting.RED
                        + super.getItemDisplayName(itemStack);
            case 1:
                return EnumChatFormatting.GREEN
                        + super.getItemDisplayName(itemStack);
            case 2:
                return EnumChatFormatting.YELLOW
                        + super.getItemDisplayName(itemStack);
            case 3:
                return EnumChatFormatting.BLUE
                        + super.getItemDisplayName(itemStack);
            default:
                return EnumChatFormatting.WHITE
                        + super.getItemDisplayName(itemStack);
        }
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack itemStack, EntityPlayer player,
            List list, boolean par4) {

        int meta = MathHelper.clamp_int(itemStack.getItemDamage(), 0, 3);

        switch (meta) {
            case 0:
                list.add("Zeolite and redscar");
                break;
            case 1:
                list.add("Zeolite and greenite");
                break;
            case 2:
                list.add("Zeolite and yellownale");
                break;
            case 3:
                list.add("Zeolite and bluetonium");
                break;
            default:
                list.add("Zeolite and unknown");
                break;
        }

    }

    @Override
    @SuppressWarnings({ "unchecked", "rawtypes" })
    @SideOnly(Side.CLIENT)
    public void getSubItems(int id, CreativeTabs creativeTab, List list) {

        for (int meta = 0; meta < 4; ++meta) {
            list.add(new ItemStack(id, 1, meta));
        }
    }
}
