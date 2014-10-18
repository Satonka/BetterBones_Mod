package huter.betterbones.main.items;

import huter.betterbones.main.lib.Constants;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class RawAnimalChunks extends Item {
	
	public static String name = "animalchunkraw";
	
	public RawAnimalChunks(){
		setUnlocalizedName(Constants.MODID + "_" + name);
		setTextureName(Constants.MODID + ":" + name);
		GameRegistry.registerItem(this, name);
		setCreativeTab(CreativeTabs.tabMaterials);
	}
}
