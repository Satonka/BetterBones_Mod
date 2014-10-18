package huter.betterbones.main.items;

import huter.betterbones.main.lib.Constants;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import cpw.mods.fml.common.registry.GameRegistry;

public class AnimalBoneRaw  extends Item {
	
	public static String name = "animalboneraw";
	
	public AnimalBoneRaw(){
		setUnlocalizedName(Constants.MODID + "_" + name);
		setTextureName(Constants.MODID + ":" + name);
		GameRegistry.registerItem(this, name);
		setCreativeTab(CreativeTabs.tabMaterials);
	}
}
