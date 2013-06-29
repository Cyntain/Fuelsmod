package com.cyntain.Fm.client.renders;

import org.lwjgl.opengl.GL11;

import com.cyntain.Fm.block.ModBlock;
import com.cyntain.Fm.tileentity.TileMixingTable;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;


public class TeRenderMixingTable extends TileEntitySpecialRenderer {

    // This method is called when minecraft renders a tile entity
    @Override
    public void renderTileEntityAt(TileEntity tileEntity, double x, double y, double z,
            float partialTicks) {

        GL11.glPushMatrix();
        // This will move our renderer so that it will be on proper place in the
        // world
        GL11.glTranslatef((float) x, (float) y, (float) z);
        TileMixingTable artificingTable = (TileMixingTable) tileEntity;
        /*
         * Note that true tile entity coordinates (tileEntity.xCoord, etc) do
         * not match to render coordinates (d, etc) that are calculated as [true
         * coordinates] - [player coordinates (camera coordinates)]
         */
        renderTable(artificingTable, ModBlock.mixingTableBlock, tileEntity.worldObj,
                tileEntity.xCoord, tileEntity.yCoord, tileEntity.zCoord, partialTicks);

        GL11.glPopMatrix();
    }

    // And this method actually renders your tile entity
    public void renderTable(TileMixingTable table, Block block, World world, int x, int y, int z,
            float partialTicks) {

        Tessellator tessellator = Tessellator.instance;

        // This will make your block brightness dependent from surroundings
        // lighting.
        float f = block.getBlockBrightness(world, x, y + 1, z);
        int l = world.getLightBrightnessForSkyBlocks(x, y + 1, z, 0);
        int l1 = l % 65536;
        int l2 = l / 65536;
        tessellator.setColorOpaque_F(f, f, f);
        OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, (float) l1, (float) l2);

        float animTimer = table.tickCount + partialTicks;

        GL11.glPushMatrix();
        {
            GL11.glTranslatef(0.5F, 0, 0.5F);
            // This line actually rotates the renderer.

            int _angle = 0;
            ForgeDirection direction = ForgeDirection.getOrientation(table.getBlockMetadata());
            if (direction != null) {
                if (direction == ForgeDirection.NORTH) {
                    _angle = 180;
                } else if (direction == ForgeDirection.SOUTH) {
                    _angle = 0;
                } else if (direction == ForgeDirection.WEST) {
                    _angle = -90;
                } else if (direction == ForgeDirection.EAST) {
                    _angle = 90;
                }
            }
GL11.glPushMatrix();{
            GL11.glRotatef(_angle + 36, 0F, 1F, 0F);
            GL11.glTranslatef(-0.5F, 0, -0.5F);
            // bindTextureByName("yourTexturePath");

            /*
             * Place your rendering code here.
             */

      //      GL11.glRotatef(-90F, 1.0F, 0F, 0F);
            GL11.glTranslatef(0F, 0.5f, 0.5F);

            GL11.glPushMatrix();
            {
                final float TILT_DEGREES = 5F;
                final float ANIM_PERIOD = 60F;

                float sinTimer = MathHelper
                        .sin((float) (((animTimer % ANIM_PERIOD) / ANIM_PERIOD) * 2 * Math.PI));
                float cosTimer = MathHelper
                        .cos((float) (((animTimer % ANIM_PERIOD) / ANIM_PERIOD) * 2 * Math.PI));
                float hover = (sinTimer) / 64F + (2.5F / 16F);
                float xTilt = cosTimer * TILT_DEGREES;
                float yTilt = sinTimer * TILT_DEGREES;
                float zTilt = sinTimer * TILT_DEGREES;
                GL11.glTranslatef(4F / 16F, 4f / 16F, hover);
                GL11.glScalef(0.5F, 0.5F, 0.5F);

                GL11.glTranslatef(0.5F, 0.5F, 1F / 32F);
                GL11.glRotatef(xTilt, 1, 0, 0);
                GL11.glRotatef(yTilt, 0, 1, 0);
                GL11.glRotatef(zTilt, 0, 0, 1);
                GL11.glTranslatef(-0.5F, -0.5F, -(1F / 32F));

                if (table.getStackInSlot(TileMixingTable.OUTPUT_SLOT_INDEX) != null) {
                    RenderUtils.render3DItemStackForDisplay(table
                            .getStackInSlot(TileMixingTable.OUTPUT_SLOT_INDEX));
                }
            }
            GL11.glPopMatrix();

            GL11.glEnable(GL11.GL_LIGHTING);
            GL11.glEnable(GL11.GL_CULL_FACE);
        }
        GL11.glPopMatrix();
        GL11.glPushMatrix();{
            GL11.glRotatef(_angle + 45, 0F, 1F, 0F);
            GL11.glTranslatef(-0.5F, 0, -0.5F);
            // bindTextureByName("yourTexturePath");

            /*
             * Place your rendering code here.
             */

      //      GL11.glRotatef(-90F, 1.0F, 0F, 0F);
            GL11.glTranslatef(0F, 0.5f, 0.75F);

            GL11.glPushMatrix();
            {
                final float TILT_DEGREES = 5F;
                final float ANIM_PERIOD = 60F;

                float sinTimer = MathHelper
                        .sin((float) (((animTimer % ANIM_PERIOD) / ANIM_PERIOD) * 2 * Math.PI));
                float cosTimer = MathHelper
                        .cos((float) (((animTimer % ANIM_PERIOD) / ANIM_PERIOD) * 2 * Math.PI));
                float hover = (sinTimer) / 64F + (2.5F / 16F);
                float xTilt = cosTimer * TILT_DEGREES;
                float yTilt = sinTimer * TILT_DEGREES;
                float zTilt = sinTimer * TILT_DEGREES;
                GL11.glTranslatef(4F / 16F, 4f / 16F, hover);
                GL11.glScalef(0.5F, 0.5F, 0.5F);

                GL11.glTranslatef(0.5F, 0.5F, 1F / 32F);
                GL11.glRotatef(xTilt, 1, 0, 0);
                GL11.glRotatef(yTilt, 0, 1, 0);
                GL11.glRotatef(zTilt, 0, 0, 1);
                GL11.glTranslatef(-0.5F, -0.5F, -(1F / 32F));

                if (table.getStackInSlot(TileMixingTable.input1_SLOT_INDEX) != null) {
                    RenderUtils.render3DItemStackForDisplay(table
                            .getStackInSlot(TileMixingTable.input1_SLOT_INDEX));
                }
            }
            GL11.glPopMatrix();

            GL11.glEnable(GL11.GL_LIGHTING);
            GL11.glEnable(GL11.GL_CULL_FACE);

    }  
       GL11.glPopMatrix();
       GL11.glPushMatrix();{
           GL11.glRotatef(_angle + 45, 0F, 1F, 0F);
           GL11.glTranslatef(-0.5F, 0, -0.5F);
           // bindTextureByName("yourTexturePath");

           /*
            * Place your rendering code here.
            */

     //      GL11.glRotatef(-90F, 1.0F, 0F, 0F);
           GL11.glTranslatef(0F, 0.5f, 0.25F);

           GL11.glPushMatrix();
           {
               final float TILT_DEGREES = 5F;
               final float ANIM_PERIOD = 60F;

               float sinTimer = MathHelper
                       .sin((float) (((animTimer % ANIM_PERIOD) / ANIM_PERIOD) * 2 * Math.PI));
               float cosTimer = MathHelper
                       .cos((float) (((animTimer % ANIM_PERIOD) / ANIM_PERIOD) * 2 * Math.PI));
               float hover = (sinTimer) / 64F + (2.5F / 16F);
               float xTilt = cosTimer * TILT_DEGREES;
               float yTilt = sinTimer * TILT_DEGREES;
               float zTilt = sinTimer * TILT_DEGREES;
               GL11.glTranslatef(4F / 16F, 4f / 16F, hover);
               GL11.glScalef(0.5F, 0.5F, 0.5F);

               GL11.glTranslatef(0.5F, 0.5F, 1F / 32F);
               GL11.glRotatef(xTilt, 1, 0, 0);
               GL11.glRotatef(yTilt, 0, 1, 0);
               GL11.glRotatef(zTilt, 0, 0, 1);
               GL11.glTranslatef(-0.5F, -0.5F, -(1F / 32F));

               if (table.getStackInSlot(TileMixingTable.input2_SLOT_INDEX) != null) {
                   RenderUtils.render3DItemStackForDisplay(table
                           .getStackInSlot(TileMixingTable.input2_SLOT_INDEX));
               }
           }
           GL11.glPopMatrix();

           GL11.glEnable(GL11.GL_LIGHTING);
           GL11.glEnable(GL11.GL_CULL_FACE);

   }  
      GL11.glPopMatrix();
}GL11.glPopMatrix();
}
}
