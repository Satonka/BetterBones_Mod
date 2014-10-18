package huter.betterbones.main.guis;

import huter.betterbones.main.containers.GrinderContainer;
import huter.betterbones.main.entities.tileentities.MeatGrinderEntity;
import huter.betterbones.main.lib.Constants;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ContainerFurnace;
import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;

public class GrinderGui extends GuiContainer {
	
	private static final ResourceLocation grinderGuiTextures = new ResourceLocation(Constants.MODID ,"textures/gui/container/furnace.png");
    private MeatGrinderEntity grinder;

	public GrinderGui(InventoryPlayer inventoryPlayer, MeatGrinderEntity grinderEntity) {
		super(new GrinderContainer(inventoryPlayer, grinderEntity));
        this.grinder = grinderEntity;
	}
	
	protected void drawGuiContainerForegroundLayer(int p_146979_1_, int p_146979_2_)
    {
        String s = this.grinder.hasCustomInventoryName() ? this.grinder.getInventoryName() : I18n.format(this.grinder.getInventoryName(), new Object[0]);
        this.fontRendererObj.drawString(s, this.xSize / 2 - this.fontRendererObj.getStringWidth(s) / 2, 6, 4210752);
        this.fontRendererObj.drawString(I18n.format("container.inventory", new Object[0]), 8, this.ySize - 96 + 2, 4210752);
    }

	@Override
	protected void drawGuiContainerBackgroundLayer(float p_146976_1_,
			int p_146976_2_, int p_146976_3_) {
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.getTextureManager().bindTexture(grinderGuiTextures);
        int k = (this.width - this.xSize) / 2;
        int l = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(k, l, 0, 0, this.xSize, this.ySize);
	}
}
