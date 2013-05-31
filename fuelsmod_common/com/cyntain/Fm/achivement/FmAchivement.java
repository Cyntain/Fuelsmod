
package com.cyntain.Fm.achivement;


import com.cyntain.Fm.item.ModItem;

import cpw.mods.fml.common.registry.LanguageRegistry;

import net.minecraft.stats.Achievement;




public class FmAchivement {

    /* This is the Dust Collector achievement */
    static final Achievement ZeoliteDust   = new Achievement(2001,
                                                   "ZeoliteDust", 4, 6,
                                                   ModItem.zeoliteDust,
                                                   (Achievement) null)
                                                   .setIndependent()
                                                   .setSpecial()
                                                   .registerAchievement();


    public static void addAchievementName(String ach, String name) {

        LanguageRegistry.instance().addStringLocalization("achievement." + ach,
                "en_US", name);
    }

    public static void addAchievementDesc(String ach, String desc) {

        LanguageRegistry.instance().addStringLocalization(
                "achievement." + ach + ".desc", "en_US", desc);
    }

    public static void addAchievementLocalizations() {

        addAchievementName("ZeoliteDust", "Dust Collector");
        addAchievementDesc("ZeoliteDust", "Another one bites the dust!");
        
    }

}
