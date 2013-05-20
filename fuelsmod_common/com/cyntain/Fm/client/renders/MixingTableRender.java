package com.cyntain.Fm.client.renders;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.world.IBlockAccess;

import org.lwjgl.opengl.GL11;

import com.cyntain.Fm.core.ClientProxy;

import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;

/**
 * @author fuj1n
 * 
 * @category
 * 
 *  Created the render. 
 *  (c) fuj1n
 *  
 */
public class MixingTableRender implements ISimpleBlockRenderingHandler {

    @Override
    public void renderInventoryBlock(Block block, int metadata, int modelID, RenderBlocks renderer) {

        GL11.glPushMatrix();
        GL11.glTranslatef(-0.5F, -0.5F, -0.5F);

        renderer.setRenderBounds(0.0, 0.6, 0.0, 1.0, 0.8, 1.0);
        renderInventoryCube(block, metadata, modelID, renderer);

        renderer.setRenderBounds(0.0, 0.0, 0.0, 0.2, 0.6, 0.2);
        renderInventoryCube(block, metadata, modelID, renderer);
        renderer.setRenderBounds(0.8, 0.0, 0.8, 1.0, 0.6, 1.0);
        renderInventoryCube(block, metadata, modelID, renderer);
        renderer.setRenderBounds(0.0, 0.0, 0.8, 0.2, 0.6, 1.0);
        renderInventoryCube(block, metadata, modelID, renderer);
        renderer.setRenderBounds(0.8, 0.0, 0.0, 1.0, 0.6, 0.2);
        renderInventoryCube(block, metadata, modelID, renderer);

        renderer.setRenderBounds(0.0, 0.9, 0.0, 1.0, 1.0, 0.2);
        renderInventoryCube(block, metadata, modelID, renderer);
        renderer.setRenderBounds(0.0, 0.9, 0.2, 0.2, 1.0, 1.0);
        renderInventoryCube(block, metadata, modelID, renderer);

        renderer.setRenderBounds(0.9, 0.8, 0.0, 1, 0.9, 0.2);
        renderInventoryCube(block, metadata, modelID, renderer);
        renderer.setRenderBounds(0.0, 0.8, 0.9, 0.2, 0.9, 1);
        renderInventoryCube(block, metadata, modelID, renderer);
        GL11.glPopMatrix();
    }

    @Override
    public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block,
            int modelId, RenderBlocks renderer) {

        renderer.setRenderBounds(0.0, 0.6, 0.0, 1.0, 0.8, 1.0);
        renderer.renderStandardBlock(block, x, y, z);

        renderer.setRenderBounds(0.0, 0.0, 0.0, 0.2, 0.6, 0.2);
        renderer.renderStandardBlock(block, x, y, z);
        renderer.setRenderBounds(0.8, 0.0, 0.8, 1.0, 0.6, 1.0);
        renderer.renderStandardBlock(block, x, y, z);
        renderer.setRenderBounds(0.0, 0.0, 0.8, 0.2, 0.6, 1.0);
        renderer.renderStandardBlock(block, x, y, z);
        renderer.setRenderBounds(0.8, 0.0, 0.0, 1.0, 0.6, 0.2);
        renderer.renderStandardBlock(block, x, y, z);

        renderer.setRenderBounds(0.0, 0.9, 0.0, 1.0, 1.0, 0.2);
        renderer.renderStandardBlock(block, x, y, z);
        renderer.setRenderBounds(0.0, 0.9, 0.2, 0.2, 1.0, 1.0);
        renderer.renderStandardBlock(block, x, y, z);

        renderer.setRenderBounds(0.9, 0.8, 0.0, 1, 0.9, 0.2);
        renderer.renderStandardBlock(block, x, y, z);
        renderer.setRenderBounds(0.0, 0.8, 0.9, 0.2, 0.9, 1);
        renderer.renderStandardBlock(block, x, y, z);
        return true;
    }

    public void renderInventoryCube(Block block, int metadata, int modelID, RenderBlocks renderer) {

        Tessellator tessellator = Tessellator.instance;

        tessellator.startDrawingQuads();
        tessellator.setNormal(0.0F, 1.0F, 0.0F);
        renderer.renderFaceYPos(block, 0, 0, 0,
                renderer.getBlockIconFromSideAndMetadata(block, 1, metadata));
        tessellator.draw();

        tessellator.startDrawingQuads();
        tessellator.setNormal(0.0F, -1.0F, 0.0F);
        renderer.renderFaceYNeg(block, 0, 0, 0,
                renderer.getBlockIconFromSideAndMetadata(block, 0, metadata));
        tessellator.draw();

        tessellator.startDrawingQuads();
        tessellator.setNormal(1.0F, 0.0F, 0.0F);
        renderer.renderFaceXPos(block, 0, 0, 0,
                renderer.getBlockIconFromSideAndMetadata(block, 2, metadata));
        tessellator.draw();

        tessellator.startDrawingQuads();
        tessellator.setNormal(-1.0F, 0.0F, 0.0F);
        renderer.renderFaceXNeg(block, 0, 0, 0,
                renderer.getBlockIconFromSideAndMetadata(block, 3, metadata));
        tessellator.draw();

        tessellator.startDrawingQuads();
        tessellator.setNormal(0.0F, 0.0F, 1.0F);
        renderer.renderFaceZPos(block, 0, 0, 0,
                renderer.getBlockIconFromSideAndMetadata(block, 4, metadata));
        tessellator.draw();

        tessellator.startDrawingQuads();
        tessellator.setNormal(0.0F, 0.0F, -1.0F);
        renderer.renderFaceZNeg(block, 0, 0, 0,
                renderer.getBlockIconFromSideAndMetadata(block, 5, metadata));
        tessellator.draw();

    }

    public void renderAngledThing(IBlockAccess world, int x, int y, int z, Block block,
            RenderBlocks renderer) {

        @SuppressWarnings("unused")
        Tessellator tessellator = Tessellator.instance;

        double d0 = 0.4000000059604645D;
        double d1 = 0.3D - d0;
        double d2 = 0.20000000298023224D;

        renderer.renderTorchAtAngle(block, (double) x - d1 - 0.1D, (double) y - d2, (double) z, 0D,
                0D, 1);
    }

    public void renderAngledThing_inventoryFriendly(Block block, RenderBlocks renderer) {

        Tessellator tessellator = Tessellator.instance;

        tessellator.startDrawingQuads();
        tessellator.setNormal(0.0F, 1.0F, 0.0F);
        double d0 = 0.4000000059604645D;
        double d1 = 0.3D - d0;
        double d2 = 0.20000000298023224D;

        renderer.renderTorchAtAngle(block, (double) 0.0D - d1 - 0.1D, (double) 0.0D - d2,
                (double) 0.0D, 0D, 0D, 1);
        tessellator.draw();
    }

    @Override
    public boolean shouldRender3DInInventory() {

        return true;
    }

    @Override
    public int getRenderId() {

        return ClientProxy.MIXINGTABLE;
    }
}
