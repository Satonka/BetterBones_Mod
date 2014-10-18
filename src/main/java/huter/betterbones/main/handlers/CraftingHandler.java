package huter.betterbones.main.handlers;

import huter.betterbones.main.blocks.ModBlocks;
import huter.betterbones.main.items.ModItems;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;

public class CraftingHandler {

	public static void init() {
		GameRegistry.addRecipe(new ItemStack(ModBlocks.handle), "xx ", " x ", " xx",
		        'x', new ItemStack(Items.stick, 1));
		GameRegistry.addRecipe(new ItemStack(ModBlocks.meatgrinder), "xxx ", "yxy", "yyy",
		        'x', new ItemStack(Items.flint, 1), 'y', new ItemStack(Blocks.cobblestone));
	}

}
