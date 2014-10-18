package huter.betterbones.main.blocks;

import java.util.Random;

import cpw.mods.fml.common.registry.GameRegistry;
import huter.betterbones.main.entities.tileentities.MeatGrinderEntity;
import huter.betterbones.main.lib.Constants;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public class Handle extends Block{
	
	public static final String name = "handle";
	
	public MeatGrinder myGrinder;
	public MeatGrinderEntity myEntity;

	protected Handle() {
		super(Material.wood);
		setBlockName(Constants.MODID + "_" + name);
		setBlockTextureName(Constants.MODID + ":" + name);
		GameRegistry.registerBlock(this, name);
		setCreativeTab(CreativeTabs.tabBlock);
	}
	
	@Override
	public boolean onBlockActivated(World w, int x, int y, int z, EntityPlayer p, int meta, float hitX, float hitY, float hitZ){
		Vec3 vec = checkNeighbors(w, x, y, z);
		myEntity = (MeatGrinderEntity) w.getTileEntity((int)vec.xCoord, (int)vec.yCoord, (int)vec.zCoord);
		if(myEntity != null){
			w.scheduleBlockUpdate(x, y, z, w.getBlock(x, y, z), 0);
			return true;
		}else{
			return false;
		}
	}
	 
	@Override
	public void onBlockAdded(World world, int x, int y, int z){
		if(checkNeighbors(world, x, y, z) != null){
			Vec3 vec = checkNeighbors(world, x, y, z);
			myGrinder = (MeatGrinder) world.getBlock((int)vec.xCoord, (int)vec.yCoord, (int)vec.zCoord);
			myEntity = (MeatGrinderEntity) world.getTileEntity((int)vec.xCoord, (int)vec.yCoord, (int)vec.zCoord);
		}
	}
	
	public Vec3 checkNeighbors(World w, int x, int y, int z){
		if(w.getBlock(x+1, y, z) == ModBlocks.meatgrinder){
			return Vec3.createVectorHelper(x+1, y, z);
		}else if(w.getBlock(x-1, y, z) == ModBlocks.meatgrinder){
			return Vec3.createVectorHelper(x-1, y, z);
		}else if(w.getBlock(x, y, z+1) == ModBlocks.meatgrinder){
			return Vec3.createVectorHelper(x, y, z+1);
		}else if(w.getBlock(x, y, z-1) == ModBlocks.meatgrinder){
			return Vec3.createVectorHelper(x, y, z-1);
		}else{
			return null;
		}
	}
	
	public void updateTick(World w, int x, int y, int z, Random p_149674_5_){
		myEntity.crank();
	}
}
