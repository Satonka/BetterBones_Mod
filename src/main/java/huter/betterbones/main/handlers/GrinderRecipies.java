package huter.betterbones.main.handlers;

import huter.betterbones.main.items.ModItems;
import net.minecraft.item.ItemStack;

public class GrinderRecipies {

	public static ItemStack[] getResult(ItemStack itemStack) {
		if(itemStack.getItem() == ModItems.cookedanimalbone){
			ItemStack[] results = new ItemStack[2];
			results[0] = new ItemStack(ModItems.cookedanimalchunks);
			results[1] = new ItemStack(ModItems.animalbone);
			return results;
		}else if(itemStack.getItem() == ModItems.rawanimalbone){
			ItemStack[] results = new ItemStack[2];
			results[0] = new ItemStack(ModItems.rawanimalchunks);
			results[1] = new ItemStack(ModItems.animalbone);
			return results;
		}else{
			return null;
		}
		
	}
	
}
