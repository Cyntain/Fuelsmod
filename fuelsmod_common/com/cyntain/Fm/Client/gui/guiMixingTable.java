package com.cyntain.Fm.Client.gui;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

import org.lwjgl.opengl.GL11;

import com.cyntain.Fm.lib.Reference;
import com.cyntain.Fm.lib.Strings;

public class guiMixingTable extends GuiContainer  {

    public guiMixingTable(EntityPlayer player, World world, int x, int y, int z) {

        super(new containerMixingTable(player.inventory, world, x, y, z));
        
    }
    @Override
    protected void drawGuiContainerForegroundLayer(int par1, int par2) {

        fontRenderer.drawString(StatCollector.translateToLocal(Strings.CONTAINER_MIXINGTABLE), 28, 6, 4210752);
        fontRenderer.drawString(StatCollector.translateToLocal(Strings.CONTAINER_INVENTORY), 8, ySize - 96 + 2, 4210752);
    }
    @Override
    protected void drawGuiContainerBackgroundLayer(float f, int i, int j) {

        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        mc.renderEngine.bindTexture(Reference.MOD_ID + ":" + "crafting.png");
        int var5 = (width - xSize) / 2;
        int var6 = (height - ySize) / 2;
        this.drawTexturedModalRect(var5, var6, 0, 0, xSize, ySize);
        
    }
    @Override
    public void onGuiClosed() {

        super.onGuiClosed();
    }
}
