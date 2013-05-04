package com.cyntain.Fm.Item;

import java.util.List;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.Icon;
import net.minecraft.util.MathHelper;

import com.cyntain.Fm.CreativeTab.CreativeTabFmAlchemy;
import com.cyntain.Fm.lib.Reference;
import com.cyntain.Fm.lib.Strings;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class itemCompounds extends Item{
    
    private static final String [] COMPOUND_NAMES = new String[] {"redscar", "greenite", "yellownale", "Bluetonium" };
   
@SideOnly(Side.CLIENT)

private Icon[] icons;

public itemCompounds(int id) {

    
    super(id);
   this.setHasSubtypes(true);
   this.setUnlocalizedName(Strings.COMPOUND_NAME);
   this.setCreativeTab(CreativeTabFmAlchemy.tabsFuelsmodAlchemy);
   maxStackSize = 64;
}
@Override

public String getUnlocalizedName(ItemStack itemstack){
    
    int meta = MathHelper.clamp_int(itemstack.getItemDamage(), 0, 3);
    return super.getUnlocalizedName() + COMPOUND_NAMES[meta];      
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
    
    icons = new Icon[COMPOUND_NAMES.length];
    
    for (int i = 0; i < COMPOUND_NAMES.length; ++i) {
        icons[i] = iconregister.registerIcon(Reference.MOD_ID.toLowerCase() + ":" + Strings.COMPOUND_NAME + "_" + COMPOUND_NAMES[i]);
    }
    
}


@Override
  public String getItemDisplayName(ItemStack itemStack) {

    int meta = MathHelper.clamp_int(itemStack.getItemDamage(), 0, 3);

    switch (meta) {
        case 0: 
            return EnumChatFormatting.RED + super.getItemDisplayName(itemStack);
        case 1:
            return EnumChatFormatting.GREEN + super.getItemDisplayName(itemStack);
        case 2:
            return EnumChatFormatting.YELLOW + super.getItemDisplayName(itemStack);
        case 3:
            return EnumChatFormatting.BLUE + super.getItemDisplayName(itemStack);            
        default:
            return EnumChatFormatting.WHITE + super.getItemDisplayName(itemStack);
    }
}


@SuppressWarnings({ "unchecked", "rawtypes" })
@SideOnly(Side.CLIENT)
public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4){
   
    int meta = MathHelper.clamp_int(par1ItemStack.getItemDamage(), 0, 3);
   
    switch(meta){
        case 0:
            par3List.add("Strange, a red hue to the compound"); break;
        case 1:
            par3List.add("Strange, a green hue to the compound");break;
        case 2:
            par3List.add("Strange, a yellow hue to the compound");break;
        case 3: 
            par3List.add("Strange, a blue hue to the compound"); break;
         default: 
             par3List.add("Strange, a white hue to the compound"); break;
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