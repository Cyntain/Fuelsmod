package com.cyntain.Fm.block;

import static net.minecraftforge.common.ForgeDirection.DOWN;
import static net.minecraftforge.common.ForgeDirection.EAST;
import static net.minecraftforge.common.ForgeDirection.NORTH;
import static net.minecraftforge.common.ForgeDirection.SOUTH;
import static net.minecraftforge.common.ForgeDirection.UP;
import static net.minecraftforge.common.ForgeDirection.WEST;

import java.util.List;
import java.util.Random;

import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;

import com.cyntain.Fm.FuelsMod;
import com.cyntain.Fm.core.ClientProxy;
import com.cyntain.Fm.creativetab.CreativeTabFmAlchemy;
import com.cyntain.Fm.lib.GUIIDs;
import com.cyntain.Fm.lib.Reference;
import com.cyntain.Fm.tileentity.TileMixingTable;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;


public class BlockMixingTable extends BlockFm implements ITileEntityProvider {

    private Random rand = new Random();

    @SideOnly(Side.CLIENT)
    private Icon[] icons;

    public BlockMixingTable(int id, Material material) {

        super(id, material);
        this.setCreativeTab(CreativeTabFmAlchemy.tabsFuelsmodAlchemy);

        this.setHardness(5f);

    }

    @Override
    public boolean canPlaceBlockOnSide(World par1World, int par2, int par3, int par4, int par5) {

        ForgeDirection dir = ForgeDirection.getOrientation(par5);
        return (dir == DOWN && par1World.isBlockSolidOnSide(par2, par3 + 1, par4, DOWN))
                || (dir == UP && par1World.isBlockSolidOnSide(par2, par3 - 1, par4, UP))
                || (dir == NORTH && par1World.isBlockSolidOnSide(par2, par3, par4 + 1, NORTH))
                || (dir == SOUTH && par1World.isBlockSolidOnSide(par2, par3, par4 - 1, SOUTH))
                || (dir == WEST && par1World.isBlockSolidOnSide(par2 + 1, par3, par4, WEST))
                || (dir == EAST && par1World.isBlockSolidOnSide(par2 - 1, par3, par4, EAST));
    }

    @Override
    public boolean canPlaceBlockAt(World par1World, int par2, int par3, int par4) {

        return par1World.isBlockSolidOnSide(par2 - 1, par3, par4, EAST)
                || par1World.isBlockSolidOnSide(par2 + 1, par3, par4, WEST)
                || par1World.isBlockSolidOnSide(par2, par3, par4 - 1, SOUTH)
                || par1World.isBlockSolidOnSide(par2, par3, par4 + 1, NORTH);
    }

    @Override
    public int getRenderType() {

        return ClientProxy.MIXINGTABLE;
    }

    public boolean renderAsNormalBlock() {

        return false;
    }

    public boolean isOpaqueCube() {

        return false;
    }

    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister iconRegister) {

        this.blockIcon = iconRegister.registerIcon(Reference.MOD_ID + ":"
                + this.getUnlocalizedName2());
    }

    @Override
    public TileEntity createNewTileEntity(World world) {

        return new TileMixingTable();
    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player,
            int par6, float par7, float par8, float par9) {

        if (player.isSneaking())
            return false;

        else {
            if (!world.isRemote) {
                TileMixingTable mixingtable = (TileMixingTable) world.getBlockTileEntity(x, y, z);

                if (mixingtable != null) {
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

                EntityItem entityItem = new EntityItem(world, x + dX, y + dY, z + dZ,
                        new ItemStack(itemStack.itemID, itemStack.stackSize,
                                itemStack.getItemDamage()));

                if (itemStack.hasTagCompound()) {
                    entityItem.getEntityItem().setTagCompound(
                            (NBTTagCompound) itemStack.getTagCompound().copy());
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
    
    @SuppressWarnings({ "unchecked" , "rawtypes" })
    public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean par4) {

        list.add("Mixin' and mixin'");
    }
    
}
