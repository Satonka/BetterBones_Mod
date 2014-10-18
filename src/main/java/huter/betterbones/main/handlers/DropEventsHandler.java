package huter.betterbones.main.handlers;

import huter.betterbones.main.items.ModItems;

import java.util.Random;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingDropsEvent;

public class DropEventsHandler {

	private int dropped, drop;
	private Random random;

	@SubscribeEvent
    public void onEntityDrop(LivingDropsEvent event) {
		random = new Random();
		dropped = random.nextInt(2) + 1; //DO NOT CHANGE THIS
		drop = random.nextInt(5);
		

		if(event.entityLiving instanceof EntityCow){
			if(drop < 1){
				event.entityLiving.entityDropItem(new ItemStack(ModItems.rawanimalbone), dropped);
			}
		}
      }
}
