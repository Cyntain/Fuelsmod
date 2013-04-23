package com.cyntain.Fm.Armor;

import net.minecraft.item.EnumArmorMaterial;
import com.cyntain.Fm.lib.Strings;

public class armorMiningHelmet extends ArmorFm {

    private EnumArmorMaterial material;
    private int armorType;
    private int damageReduceAmount;

    public armorMiningHelmet(int id, EnumArmorMaterial par2EnumArmorMaterial, int par4) {
        super(id, par2EnumArmorMaterial, par4);
        this.setUnlocalizedName(Strings.MINING_HELMET_NAME);
        this.material = par2EnumArmorMaterial;
        this.armorType = par4;
        this.damageReduceAmount = par2EnumArmorMaterial.getDamageReductionAmount(par4);
        this.setMaxDamage(par2EnumArmorMaterial.getDurability(par4));
    }
    
    public EnumArmorMaterial getArmorMaterial()
    {
        return this.material;
    }
    
}
