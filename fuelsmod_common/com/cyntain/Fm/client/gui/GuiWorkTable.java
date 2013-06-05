package com.cyntain.Fm.client.gui;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.StatCollector;

import org.lwjgl.opengl.GL11;

import com.cyntain.Fm.lib.Strings;
import com.cyntain.Fm.tileentity.TileWorkTable;


public class GuiWorkTable extends GuiContainer {
   // private TileWorkTable tileWorkTable;

    public GuiWorkTable(InventoryPlayer player, TileWorkTable tileWorkTable) {

        super(new ContainerWorkTable(player, tileWorkTable));
        ySize = 176;
        xSize = 176;
        //this.tileWorkTable = tileWorkTable;
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int par1, int par2) {

       
        fontRenderer.drawString("Workshop Table",
                8, 5, 4210752);
        fontRenderer.drawString(StatCollector.translateToLocal(Strings.CONTAINER_INVENTORY), 8,
                ySize - 104 + 2, 4210752);
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float f, int i, int j) {

        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        mc.renderEngine.bindTexture("/mods/Fm/textures/gui/workshopTable.png");
        int scaledX = (width - xSize) / 2;
        int scaledY = (height - ySize) / 2;
        this.drawTexturedModalRect(scaledX, scaledY, 0, 0, xSize, ySize);
        
    }
}