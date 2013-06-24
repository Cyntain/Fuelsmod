package com.cyntain.Fm.lib;

import net.minecraft.src.ModLoader;


public class ModLoaded {

    public static boolean loaded = ModLoader.isModLoaded("Fm");

    public static void Mod_Loaded() {

        System.out.println("[FUELSMOD]  Mod Loaded: " + loaded);

    }

    public static void PreInit_modloaded() {

        System.out.println("[FUELSMOD]  Mod Loaded after PreInitilization: " + loaded);
    }

}
