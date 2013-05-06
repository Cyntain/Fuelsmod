package com.cyntain.Fm.Configuration;

import java.io.File;
import java.util.logging.Level;

import com.cyntain.Fm.lib.ItemIDs;
import com.cyntain.Fm.lib.Reference;
import com.cyntain.Fm.lib.Strings;

import cpw.mods.fml.common.FMLLog;

import net.minecraftforge.common.Configuration;


public class ConfigurationHandler {

    public static Configuration configuration;
    
       
    public static void init(File configFile){
        
        configuration = new Configuration(configFile);
        try {
            configuration.load();

            ItemIDs.BERYLLIUM_CHUNK = configuration.getItem(Strings.BERYLLIUM_CHUNK_NAME, ItemIDs.BERYLLIUM_CHUNK_DEFAULT).getInt(ItemIDs.BERYLLIUM_CHUNK_DEFAULT);
            ItemIDs.BERYLLIUM_CLUSTER = configuration.getItem(Strings.BERYLLIUM_CLUSTER_NAME, ItemIDs.BERYLLIUM_CLUSTER_DEFAULT).getInt(ItemIDs.BERYLLIUM_CLUSTER_DEFAULT);
            ItemIDs.BERYLLIUM_INGOT = configuration.getItem(Strings.BERYLLIUM_INGOT_NAME, ItemIDs.BERYLLIUM_INGOT_DEFAULT).getInt(ItemIDs.BERYLLIUM_INGOT_DEFAULT);
            
            ItemIDs.COPPER_CHUNK = configuration.getItem(Strings.COPPER_CHUNK_NAME, ItemIDs.COPPER_CHUNK_DEFAULT).getInt(ItemIDs.COPPER_CHUNK_DEFAULT);
            ItemIDs.COPPER_CLUSTER = configuration.getItem(Strings.COPPER_CLUSTER_NAME, ItemIDs.COPPER_CLUSTER_DEFAULT).getInt(ItemIDs.COPPER_CLUSTER_DEFAULT);
            ItemIDs.COPPER_INGOT = configuration.getItem(Strings.COPPER_INGOT_NAME, ItemIDs.COPPER_INGOT_DEFAULT).getInt(ItemIDs.COPPER_INGOT_DEFAULT);
            
            ItemIDs.OSMIUM_CHUNK = configuration.getItem(Strings.OSMIUM_CHUNK_NAME, ItemIDs.OSMIUM_CHUNK_DEFAULT).getInt(ItemIDs.OSMIUM_CHUNK_DEFAULT);
            ItemIDs.OSMIUM_INGOT = configuration.getItem(Strings.OSMIUM_INGOT_NAME, ItemIDs.OSMIUM_INGOT_DEFAULT).getInt(ItemIDs.OSMIUM_INGOT_DEFAULT);
            ItemIDs.OSMIUM_GRATE = configuration.getItem(Strings.OSMIUM_GRATE_NAME, ItemIDs.OSMIUM_GRATE_DEFAULT).getInt(ItemIDs.OSMIUM_GRATE_DEFAULT);
            
            ItemIDs.ZEOLITE_DUST = configuration.getItem(Strings.ZEOLITE_DUST_NAME, ItemIDs.ZEOLITE_DUST_DEFAULT).getInt(ItemIDs.ZEOLITE_DUST_DEFAULT);
            ItemIDs.ZEOLITE_DUST_VIAL = configuration.getItem(Strings.ZEOLITE_DUST_GLASS_NAME, ItemIDs.ZEOLITE_DUST_VIAL_DEFAULT).getInt(ItemIDs.ZEOLITE_DUST_VIAL_DEFAULT);
            ItemIDs.ZEOLITE_DYED = configuration.getItem(Strings.ZEOLITE_DYED_NAME, ItemIDs.ZEOLITE_DYED_DEFAULT).getInt(ItemIDs.ZEOLITE_DYED_DEFAULT);
            
            ItemIDs.EMPTY_VIAL = configuration.getItem(Strings.EMPTY_VIAL_NAME, ItemIDs.EMPTY_VIAL_DEFAULT).getInt(ItemIDs.EMPTY_VIAL_DEFAULT);
            
            ItemIDs.COMPOUND = configuration.getItem(Strings.ITEM_COMPOUND_NAME, ItemIDs.COMPOUND_DEFAULT).getInt(ItemIDs.COMPOUND_DEFAULT);
            
    }catch (Exception e) {
        FMLLog.log(Level.SEVERE, e, Reference.MOD_NAME + " has had a problem loading its configuration");
    }
    finally {
        
        configuration.save();
       
        System.out.println("[" + Reference.MOD_NAME.toUpperCase() + "]" + " loaded config file");
        
    }
       
    
}}
