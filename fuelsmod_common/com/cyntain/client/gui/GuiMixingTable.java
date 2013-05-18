package com.cyntain.Fm.client.gui;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.StatCollector;

import org.lwjgl.opengl.GL11;

import com.cyntain.Fm.tileentity.TileMixingTable;
import com.cyntain.Fm.lib.Strings;


public class GuiMixingTable extends GuiContainer {

    private TileMixingTable tilemixingtable;

    public GuiMixingTable(InventoryPlayer player, TileMixingTable tilemixingtable) {

        super(new ContainerMixingTable(player, tilemixingtable));
        ySize = 176;
        xSize = 176;
        this.tilemixingtable = tilemixingtable;
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int par1, int par2) {

        String containerName = tilemixingtable.isInvNameLocalized() ? tilemixingtable.getInvName()
                : StatCollector.translateToLocal(tilemixingtable.getInvName());
        fontRenderer.drawString(containerName,
                xSize / 2 - fontRenderer.getStringWidth(containerName) / 2, 6, 4210752);
        fontRenderer.drawString(StatCollector.translateToLocal(Strings.CONTAINER_INVENTORY), 8,
                ySize - 104 + 2, 4210752);
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float f, int i, int j) {

        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        mc.renderEngine.bindTexture("/mods/Fm/textures/gui/mixingTable.png");
        int var5 = (width - xSize) / 2;
        int var6 = (height - ySize) / 2;
        this.drawTexturedModalRect(var5, var6, 0, 0, xSize, ySize);

    }
}
