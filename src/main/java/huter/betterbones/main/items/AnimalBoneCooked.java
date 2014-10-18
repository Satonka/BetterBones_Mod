package huter.betterbones.main.items;

import cpw.mods.fml.common.registry.GameRegistry;
import huter.betterbones.main.lib.Constants;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class AnimalBoneCooked extends ItemFood {
	
	public static String name = "animalbonecooked";

	public AnimalBoneCooked() {
		super(2, false);
		setUnlocalizedName(Constants.MODID + "_" + name);
		setTextureName(Constants.MODID + ":" + name);
		GameRegistry.registerItem(this, name);
		setCreativeTab(CreativeTabs.tabMaterials);
	}

	public ItemStack onEaten(ItemStack p_77654_1_, World p_77654_2_, EntityPlayer p_77654_3_)
    {
        super.onEaten(p_77654_1_, p_77654_2_, p_77654_3_);
        return new ItemStack(ModItems.animalbone);
    }
}
