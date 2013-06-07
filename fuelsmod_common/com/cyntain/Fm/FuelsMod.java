package com.cyntain.Fm;

import java.io.File;

import com.cyntain.Fm.block.ModBlock;
import com.cyntain.Fm.block.WorldGenerator;
import com.cyntain.Fm.configuration.ConfigurationHandler;
import com.cyntain.Fm.core.handlers.LocalizationHandler;
import com.cyntain.Fm.core.helper.MixingTableHelper;
import com.cyntain.Fm.core.proxy.CommonProxy;
import com.cyntain.Fm.item.ModItem;
import com.cyntain.Fm.lib.ModLoaded;
import com.cyntain.Fm.lib.Reference;
import com.cyntain.Fm.network.PacketHandler;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import de.paleocrafter.pmfw.network.PaleoPacketHandler;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION_NUMBER)
@NetworkMod(channels = { Reference.CHANNEL_NAME }, clientSideRequired = true, serverSideRequired = false, packetHandler = PacketHandler.class)
public class FuelsMod {
    
   
    @Instance(Reference.MOD_ID)
    public static FuelsMod instance;

    @SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
    public static CommonProxy proxy;

    @PreInit
    public void preInit(FMLPreInitializationEvent event) {
        PaleoPacketHandler.registerChannel();
        proxy.registerRenders();
        ConfigurationHandler.init(new File(event.getModConfigurationDirectory()
                .getAbsolutePath()
                + File.separator
                + Reference.CHANNEL_NAME
                + File.separator + Reference.MOD_ID + ".cfg"));
        LocalizationHandler.loadLanguages();
        ModItem.init();
        ModBlock.init();
        proxy.PreInitRenders();

        MixingTableHelper.initRecipes();
        ModLoaded.PreInit_modloaded();

    }

    @Init
    public void load(FMLInitializationEvent event) {

        GameRegistry.registerWorldGenerator(new WorldGenerator());
        NetworkRegistry.instance().registerGuiHandler(instance, proxy);

        proxy.registerTileEntities();
        ModLoaded.Mod_Loaded();

    }

}
