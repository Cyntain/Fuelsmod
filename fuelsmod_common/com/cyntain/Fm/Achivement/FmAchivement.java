package com.cyntain.Fm.Achivement;

import com.cyntain.Fm.Item.ModItem;

import cpw.mods.fml.common.registry.LanguageRegistry;

import net.minecraft.stats.Achievement;
public class FmAchivement {

    
    /*This is the Dust Collector achievement*/
    static final Achievement ZeoliteDust = new Achievement(2001, "ZeoliteDust", 4, 6, ModItem.zeoliteDust, (Achievement)null).setIndependent().setSpecial().registerAchievement();
    /*This is the Cluster Hunter achievement*/
    static final Achievement CopperCluster = new Achievement(2002, "CopperCluster", 6, 4, ModItem.ClusterCopper, (Achievement)null).setIndependent().setSpecial().registerAchievement();
    
    
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
                   addAchievementDesc("ZeoliteDust", "Another one bites the dust!");
                   addAchievementName("CopperCluster", "Clustering Algorithms");
                   addAchievementDesc("CopperCluster", "1+1 = 2");
    }
    
   
}
