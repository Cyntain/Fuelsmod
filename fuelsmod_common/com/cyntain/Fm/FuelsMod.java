package com.cyntain.Fm;

import java.io.File;

import com.cyntain.Fm.Achivement.FmAchivement;
import com.cyntain.Fm.Block.ModMultiBlock;
import com.cyntain.Fm.Block.WorldGenerator;
import com.cyntain.Fm.Item.ModItem;
import com.cyntain.Fm.Block.ModBlock;
import com.cyntain.Fm.Configuration.ConfigurationHandler;
import com.cyntain.Fm.core.handlers.LocalizationHandler;
import com.cyntain.Fm.core.proxy.CommonProxy;
import com.cyntain.Fm.lib.ModLoaded;
import com.cyntain.Fm.lib.Reference;

import cpw.mods.fml.common.*;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

/*            FuelsMod     
 * 
 * @Authors: Cyntain and Paronamixxe
 * 
 * FuelsMod
 * 
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 * @credit: Visual_Argonian, Pahimar and Plenty_of_Fish
 * */

@Mod(  modid = Reference.MOD_ID,
       name = Reference.MOD_NAME,
       version = Reference.VERSION_NUMBER)

@NetworkMod( clientSideRequired = true,
              serverSideRequired = false)



    public class FuelsMod {
             
@Instance(Reference.MOD_ID)
                public static FuelsMod instance;
  
@SidedProxy(
            clientSide = Reference.CLIENT_PROXY_CLASS,
             serverSide = Reference.SERVER_PROXY_CLASS)
                public static CommonProxy proxy;
 
@PreInit
        public void preInit(FMLPreInitializationEvent event) {
        proxy.registerRenders();
        
        ConfigurationHandler.init(new File(event.getModConfigurationDirectory().getAbsolutePath() + File.separator + Reference.CHANNEL_NAME + File.separator + Reference.MOD_ID + ".cfg"));
           
        LocalizationHandler.loadLanguages();
           ModItem.init();
           ModBlock.init();
           ModLoaded.PreInit_modloaded(); 
         
    }
@Init
    public void load(FMLInitializationEvent event) {
    FmAchivement.addAchievementLocalizations();
    
    GameRegistry.registerWorldGenerator(new WorldGenerator());
   
    ModMultiBlock.Init();
        proxy.registerTileEntities();
            LanguageRegistry.instance().addStringLocalization("multiSmelter.container.multiSmelter", "Multi-Smelter");
                NetworkRegistry.instance().registerGuiHandler(this, proxy);

    ModLoaded.Mod_Loaded();          //keep at the end of the load method shows if all blocks have been initialised 
    
    }

    }
