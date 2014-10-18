package huter.betterbones.main.blocks;

import huter.betterbones.main.BetterBones;
import huter.betterbones.main.entities.tileentities.MeatGrinderEntity;
import huter.betterbones.main.lib.Constants;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class MeatGrinder extends BlockContainer {
	
	public static final String name = "meatgrinder";
	private IIcon bottomTexture;
	private IIcon topTexture;
	private boolean grinding;

	protected MeatGrinder() {
		super(Material.rock);
		setBlockName(Constants.MODID + "_" + name);
		GameRegistry.registerBlock(this, name);
		setCreativeTab(CreativeTabs.tabBlock);
	}
	
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int meta, float hitX, float hitY, float hitZ){
    	TileEntity tileEntity = world.getTileEntity(x, y, z);
        if (tileEntity == null || player.isSneaking()) {
        	return false;
        }
    //code to open gui explained later
        player.openGui(BetterBones.instance, 0, world, x, y, z);
            return true;
	}
    
	@SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta)
    {
        return side == 1 ? this.topTexture : (side == 0 ? this.bottomTexture : (side != meta ? this.blockIcon : this.bottomTexture));
    }
	
	@SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister register)
    {
        this.blockIcon = register.registerIcon("furnace_side");
        this.bottomTexture = register.registerIcon("furnace_top");
        this.topTexture = register.registerIcon(grinding ? Constants.MODID + ":" + "grinderTopAnim" : Constants.MODID + ":" + "grinderTop1");
    }

	@Override
	public TileEntity createNewTileEntity(World world, int p_149915_2_) {
		return new MeatGrinderEntity();
	}
	
}
