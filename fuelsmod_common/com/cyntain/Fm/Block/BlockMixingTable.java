package com.cyntain.Fm.Block;

import java.util.Random;

import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
//import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
//import net.minecraft.world.World;

import com.cyntain.Fm.FuelsMod;
//import com.cyntain.Fm.FuelsMod;
import com.cyntain.Fm.CreativeTab.CreativeTabFm;
import com.cyntain.Fm.TileEntity.tileMixingTable;
import com.cyntain.Fm.lib.GUIIDs;
//import com.cyntain.Fm.lib.GUIIDs;
import com.cyntain.Fm.lib.Reference;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockMixingTable extends BlockFm {
    private Random rand = new Random();
    public final String[] FACES = new String[] { "top", "bottom", "side" };
    @SideOnly(Side.CLIENT)
    private Icon[] icons;


    public BlockMixingTable(int id, Material material) {

        super(id, material);
        this.setCreativeTab(CreativeTabFm.tabsFuelMod);
        this.setHardness(5f);
        
    }
         
    @SideOnly(Side.CLIENT)
    public Icon sides, bottom, top;
   
    //Textures
    @SideOnly(Side.CLIENT)
    
        public void registerIcons(IconRegister iconregister)
        {    
        this.bottom = iconregister.registerIcon(Reference.MOD_ID + ":" + this.getUnlocalizedName2() + "_" + FACES[0]);
        this.top = iconregister.registerIcon(Reference.MOD_ID + ":" + this.getUnlocalizedName2() + "_" + FACES[1]);
        this.sides =  iconregister.registerIcon(Reference.MOD_ID + ":" + this.getUnlocalizedName2() + "_" + FACES[2]);    
        }
        

@SideOnly(Side.CLIENT)
    public Icon getBlockTextureFromSideAndMetadata(int side, int meta)
    {
        if(side == 0){
            return top;}
        else if (side == 1){
            return bottom;}
        else {
            return sides; }
        }

            public TileEntity createNewTileEntity(World world) {

                return new tileMixingTable();
        }

                    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int par6, float par7, float par8, float par9)
                    {
                        if (player.isSneaking())
                            return false;

                    else {
                            if(!world.isRemote){
                                tileMixingTable mixingtable = (tileMixingTable) world.getBlockTileEntity(x, y, z);

                                if (mixingtable != null) {
                                    System.out.println("Block activated");
                                    player.openGui(FuelsMod.instance, GUIIDs.mixingTable, world, x, y, z);
                                }
                            }
                        }
                        return true;
                    }
@Override
        public void breakBlock(World world, int x, int y, int z, int id, int meta) {

        dropInventory(world, x, y, z);
            super.breakBlock(world, x, y, z, id, meta);
    }

    private void dropInventory(World world, int x, int y, int z) {

        TileEntity tileEntity = world.getBlockTileEntity(x, y, z);

        if (!(tileEntity instanceof IInventory))
            return;

        IInventory inventory = (IInventory) tileEntity;

            for (int i = 0; i < inventory.getSizeInventory(); i++) {

                ItemStack itemStack = inventory.getStackInSlot(i);

                if (itemStack != null && itemStack.stackSize > 0) {
                    float dX = rand.nextFloat() * 0.8F + 0.1F;
                    float dY = rand.nextFloat() * 0.8F + 0.1F;
                    float dZ = rand.nextFloat() * 0.8F + 0.1F;

                    EntityItem entityItem = new EntityItem(world, x + dX, y + dY, z + dZ, new ItemStack(itemStack.itemID, itemStack.stackSize, itemStack.getItemDamage()));

                    if (itemStack.hasTagCompound()) {
                        entityItem.getEntityItem().setTagCompound((NBTTagCompound) itemStack.getTagCompound().copy());
            }

                    float factor = 0.05F;
                    entityItem.motionX = rand.nextGaussian() * factor;
                    entityItem.motionY = rand.nextGaussian() * factor + 0.2F;
                    entityItem.motionZ = rand.nextGaussian() * factor;
                    world.spawnEntityInWorld(entityItem);
                    itemStack.stackSize = 0;
                }
            }
    }
  }
        




   
    
    
