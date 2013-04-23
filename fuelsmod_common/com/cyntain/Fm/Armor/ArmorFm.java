package com.cyntain.Fm.Armor;

import com.cyntain.Fm.CreativeTab.CreativeTabFm;
import com.cyntain.Fm.lib.Reference;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;

public class ArmorFm extends Item {

    public ArmorFm(int id, EnumArmorMaterial par2EnumArmorMaterial, int par4) {
        
        super (id);
        maxStackSize = 1;
        setCreativeTab(CreativeTabFm.tabsFuelMod);
        
    }

    @SideOnly(Side.CLIENT)
    @Override
            public void updateIcons(IconRegister iconRegister) {
                    this.iconIndex = iconRegister.registerIcon(Reference.MOD_ID + ":" + this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(".") + 1) );
      
                    
        }
    
}
