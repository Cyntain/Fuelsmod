package com.cyntain.Fm.Achivement;

import com.cyntain.Fm.Item.ModItem;

import cpw.mods.fml.common.registry.LanguageRegistry;

import net.minecraft.stats.Achievement;
import net.minecraft.stats.AchievementList;

public class FmAchivement {

    
    /*This is the Dust Collector achievement*/
    static final Achievement ZeoliteDust = new Achievement(2001, "ZeoliteDust", 4, 6, ModItem.zeoliteDust, AchievementList.buildPickaxe ).setSpecial().registerAchievement();
    /*This is the Cluster Hunter achievement*/
    static final Achievement copper_Cluster = new Achievement(2002, "Copper_Cluster", 6, 4, ModItem.ClusterCopper, AchievementList.buildBetterPickaxe).setSpecial().registerAchievement();
    
    
    public static void addAchievementName(String ach, String name)
    {
            LanguageRegistry.instance().addStringLocalization("achievement." + ach, "en_US", name);
    }

    public static void addAchievementDesc(String ach, String desc)
    {
            LanguageRegistry.instance().addStringLocalization("achievement." + ach + ".desc", "en_US", desc);
    }
    
   public static void addAchievementLocalizations()
    {
                   addAchievementName("ZeoliteDust", "Dust Collector");
                   addAchievementDesc("ZeoliteDust", "You collected dust!");
                   addAchievementName("Copper_Cluster", "Cluster Hunter");
                   addAchievementDesc("Copper_Cluster", "You are heading towards molten Metal");
    }
    
   
}
