package com.cyntain.Fm.lib;

import net.minecraft.src.ModLoader;

    public class ModLoaded {
    
        public static boolean loaded = ModLoader.isModLoaded("Fm");
     
 
     public static void Mod_Loaded(){
      
       if   (loaded == true){
                   System.out.println("[FUELSMOD]  Mod Loaded: TRUE");
       }
       else if (loaded == false)
       {
                   System.out.println("[FUELSMOD]  Mod Loaded: FALSE");
       }
       else // if null
       {
                   System.out.println("[FUELSMOD]  Mod Loaded: FALSE");
       }
     }
       
     public static void PreInit_modloaded(){
           
           if   (loaded == true){
                       System.out.println("[FUELSMOD]  Mod Loaded after PreInitilization: TRUE");
           }
           else if (loaded == false)
           {
                       System.out.println("[FUELSMOD]  Mod Loaded after PreInitilization: FALSE");
           }
           else // if null
           {
                       System.out.println("[FUELSMOD]  Mod Loaded after PreInitilization: FALSE");
           }
            
         }
      
            
            }
     
     
  
   

