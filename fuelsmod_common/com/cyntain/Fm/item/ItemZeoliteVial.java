package com.cyntain.Fm.item;

import java.util.List;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.Icon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

import org.lwjgl.input.Keyboard;

import com.cyntain.Fm.creativetab.CreativeTabFmAlchemy;
import com.cyntain.Fm.lib.Colours;
import com.cyntain.Fm.lib.ItemIDs;
import com.cyntain.Fm.lib.Reference;
import com.cyntain.Fm.lib.Strings;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;


public class ItemZeoliteVial extends ItemFood {

    public static final String[] VIAL_NAME      = new String[]{ "Zeo" , "Reden" , "Greue" ,
            "Yellen" , "Lueel"                 };
    public static final String[] DISCOVER       = new String[]{ "Invisablity" , "Fire Resistance" ,
            "Healing" , "Night Vision" , "Breath" };
    private int[]                potionEffect   = { 14 , 12 , 10 , 16 , 13 };
    private int[]                potionDuration = { 60 };
    private int[]                potionTeir     = { 3 };

    public boolean               effect1        = false;
    public boolean               effect2        = false;
    public boolean               effect3        = false;
    public boolean               effect4        = false;
    public boolean               effect5        = false;

    @SideOnly(Side.CLIENT)
    private Icon[]               icons;

    public ItemZeoliteVial(int id) {

        super(id, 0, 0F, false);
        this.setUnlocalizedName(Strings.ZEOLITE_DUST_GLASS_NAME);
        this.setAlwaysEdible();
        this.setCreativeTab(CreativeTabFmAlchemy.tabsFuelsmodAlchemy);
        setHasSubtypes(true);
        this.maxStackSize = 16;
    }

    @Override
    public String getUnlocalizedName(ItemStack itemstack) {

        int meta = MathHelper.clamp_int(itemstack.getItemDamage(), 0, 6);
        return super.getUnlocalizedName() + VIAL_NAME[meta];
    }

    @Override
    @SideOnly(Side.CLIENT)
    public Icon getIconFromDamage(int meta) {

        int j = MathHelper.clamp_int(meta, 0, 6);
        return icons[j];
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister iconregister) {
        icons = new Icon[VIAL_NAME.length];
        
        for(int i = 0; i < VIAL_NAME.length; ++i){
            icons[i] = iconregister.registerIcon(Reference.MOD_ID + ":" + Strings.ZEOLITE_DUST_GLASS_NAME + VIAL_NAME[i]);
        }
    }
    @Override
    @SuppressWarnings({ "unchecked" , "rawtypes" })
    public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean par) {

        int meta = MathHelper.clamp_int(itemStack.getItemDamage(), 0, 4);
        switch (meta) {
            case 0:
                list.add("Tasty! But where does it keep going?");
                list.add("Press " + Colours.GOLD + "shift" + Colours.GRAY
                        + " to see more information");
                if (Keyboard.isKeyDown(Keyboard.KEY_RSHIFT)
                        || Keyboard.isKeyDown(Keyboard.KEY_LSHIFT)) {
                    if (effect1 == true) {
                        list.add(Colours.WHITE + "Effect:" + " " + Colours.RED
                                + DISCOVER[meta].toUpperCase());
                    } else {
                        list.add(Colours.WHITE + "Effect:" + " " + Colours.GRAY
                                + "Unknown".toUpperCase());
                    }
                }
                break;

            case 1:
                list.add("Tasty! But where does that smoke come from?");
                list.add("Press " + Colours.GOLD + "shift" + Colours.GRAY
                        + " to see more information");
                if (Keyboard.isKeyDown(Keyboard.KEY_RSHIFT)
                        || Keyboard.isKeyDown(Keyboard.KEY_LSHIFT)) {
                    if (effect2 == true) {
                        list.add(Colours.WHITE + "Effect:" + " " + Colours.RED
                                + DISCOVER[meta].toUpperCase());
                    } else {
                        list.add(Colours.WHITE + "Effect:" + " " + Colours.GRAY
                                + "Unknown".toUpperCase());
                    }
                }
                break;
            case 2:
                list.add("Tasty! But why is there iron in there?");
                list.add("Press " + Colours.GOLD + "shift" + Colours.GRAY
                        + " to see more information");
                if (Keyboard.isKeyDown(Keyboard.KEY_RSHIFT)
                        || Keyboard.isKeyDown(Keyboard.KEY_LSHIFT)) {
                    if (effect3 == true) {
                        list.add(Colours.WHITE + "Effect:" + " " + Colours.RED
                                + DISCOVER[meta].toUpperCase());
                    } else {
                        list.add(Colours.WHITE + "Effect:" + " " + Colours.GRAY
                                + "Unknown".toUpperCase());
                    }
                }
                break;
            case 3:
                list.add("Tasty! But why is it glowing?");
                list.add("Press " + Colours.GOLD + "shift" + Colours.GRAY
                        + " to see more information");
                if (Keyboard.isKeyDown(Keyboard.KEY_RSHIFT)
                        || Keyboard.isKeyDown(Keyboard.KEY_LSHIFT)) {
                    if (effect4 == true) {
                        list.add(Colours.WHITE + "Effect:" + " " + Colours.RED
                                + DISCOVER[meta].toUpperCase());
                    } else {
                        list.add(Colours.WHITE + "Effect:" + " " + Colours.GRAY
                                + "Unknown".toUpperCase());
                    }
                }
                break;
            case 4:
                list.add("Tasty! But why is it dripping water?");
                list.add("Press " + Colours.GOLD + "shift" + Colours.GRAY
                        + " to see more information");
                if (Keyboard.isKeyDown(Keyboard.KEY_RSHIFT)
                        || Keyboard.isKeyDown(Keyboard.KEY_LSHIFT)) {
                    if (effect5 == true) {
                        list.add(Colours.WHITE + "Effect:" + " " + Colours.RED
                                + DISCOVER[meta].toUpperCase());
                    } else {
                        list.add(Colours.WHITE + "Effect:" + " " + Colours.GRAY
                                + "Unknown".toUpperCase());
                    }
                }
                break;
            default:
                list.add("Tasty!");
                list.add("Press " + Colours.GOLD + "shift" + Colours.GRAY
                        + " to see more information");
                if (Keyboard.isKeyDown(Keyboard.KEY_RSHIFT)
                        || Keyboard.isKeyDown(Keyboard.KEY_LSHIFT)) {
                    list.add(Colours.WHITE + "Effect:" + " " + Colours.GRAY
                            + "Unknown".toUpperCase());
                }
                break;

        }
    }

    public void onFoodEaten(ItemStack itemStack, World world, EntityPlayer player) {

        player.getFoodStats().addStats(this);
        this.addPotionEffects(itemStack, world, player);
        int meta = MathHelper.clamp_int(itemStack.getItemDamage(), 0, 4);
        if (meta == 0) {
            player.inventory.addItemStackToInventory(new ItemStack(ModItem.emptyVial));
            player.inventory.consumeInventoryItem(ItemIDs.ZEOLITE_DUST_VIAL);
            effect1 = true;
        } else if (meta == 1) {
            player.inventory.addItemStackToInventory(new ItemStack(ModItem.emptyVial));
            player.inventory.consumeInventoryItem(ItemIDs.ZEOLITE_DUST_VIAL + meta);
            effect2 = true;
        } else if (meta == 2) {
            player.inventory.addItemStackToInventory(new ItemStack(ModItem.emptyVial));
            player.inventory.consumeInventoryItem(ItemIDs.ZEOLITE_DUST_VIAL + meta);
            effect3 = true;
        } else if (meta == 3) {
            player.inventory.addItemStackToInventory(new ItemStack(ModItem.emptyVial));
            player.inventory.consumeInventoryItem(ItemIDs.ZEOLITE_DUST_VIAL + meta);
            effect4 = true;
        } else {
            player.inventory.addItemStackToInventory(new ItemStack(ModItem.emptyVial));
            player.inventory.consumeInventoryItem(ItemIDs.ZEOLITE_DUST_VIAL + meta);
            effect5 = true;
        }
    }

    private void addPotionEffects(ItemStack itemStack, World world, EntityPlayer player) {

        int meta = MathHelper.clamp_int(itemStack.getItemDamage(), 0, 5);
        switch (meta) {
            case 0:
                player.addPotionEffect(new PotionEffect(potionEffect[0], potionDuration[0] * 20,
                        potionTeir[0]));
                break;
            case 1:
                player.addPotionEffect(new PotionEffect(potionEffect[1], potionDuration[0] * 20,
                        potionTeir[0]));
                break;
            case 2:
                player.addPotionEffect(new PotionEffect(potionEffect[2], potionDuration[0] * 20,
                        potionTeir[0]));
                break;
            case 3:
                player.addPotionEffect(new PotionEffect(potionEffect[3], potionDuration[0] * 20,
                        potionTeir[0]));
                break;
            case 4:
                player.addPotionEffect(new PotionEffect(potionEffect[4], potionDuration[0] * 20,
                        potionTeir[0]));
                break;

            default:
                player.addPotionEffect(new PotionEffect(potionEffect[4], potionDuration[0] * 20,
                        potionTeir[0]));
                break;
        }
    }

    public EnumAction onItemRightClick(ItemStack itemStack) {

        return EnumAction.drink;
    }

    public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player) {

        player.setItemInUse(itemStack, this.getMaxItemUseDuration(itemStack));
        return itemStack;
    }

    public boolean hasEffect() {

        return true;
    }

    @Override
    @SuppressWarnings({ "unchecked" , "rawtypes" })
    @SideOnly(Side.CLIENT)
    public void getSubItems(int id, CreativeTabs creativeTab, List list) {

        for (int meta = 0; meta < 5; ++meta) {
            list.add(new ItemStack(id, 1, meta));
        }
    }
}