package com.cyntain.Fm;

import com.cyntain.Fm.Block.ModBlock;
import com.cyntain.Fm.Item.ModItem;
import com.cyntain.Fm.core.proxy.CommonProxy;
import com.cyntain.Fm.lib.Reference;

import cpw.mods.fml.common.*;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
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
        ModItem.init();
        ModBlock.init();

    }
    @Init
    public void load(FMLInitializationEvent event) {
    
    }
    
}
