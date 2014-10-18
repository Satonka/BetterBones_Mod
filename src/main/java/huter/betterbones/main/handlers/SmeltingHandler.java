package huter.betterbones.main.handlers;

import net.minecraft.item.ItemStack;
import huter.betterbones.main.items.ModItems;
import cpw.mods.fml.common.registry.GameRegistry;

public class SmeltingHandler {

	public static void init() {
		GameRegistry.addSmelting(ModItems.rawanimalbone, new ItemStack(ModItems.cookedanimalbone), .35f);
	}
}
