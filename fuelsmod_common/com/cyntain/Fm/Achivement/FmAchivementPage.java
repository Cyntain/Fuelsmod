package com.cyntain.Fm.Achivement;

import com.cyntain.Fm.lib.Strings;

import net.minecraft.stats.Achievement;
import net.minecraftforge.common.AchievementPage;

public class FmAchivementPage extends AchievementPage {
    public FmAchivementPage(String name, Achievement[] achievements) {

        super(name, achievements);
        
    }




    public static AchievementPage FmPage = new AchievementPage(Strings.Page1_Name, FmAchivement.CopperCluster, FmAchivement.ZeoliteDust);
    

    
    
public static void Init(){
    AchievementPage.registerAchievementPage(FmPage);
  /*
   * Does not work.
   */
}

}
