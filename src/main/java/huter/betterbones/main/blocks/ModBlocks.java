package huter.betterbones.main.blocks;

import net.minecraft.block.Block;

public class ModBlocks {
	
	public static Block meatgrinder;
	public static Block handle;

	public static void init() {
		meatgrinder = new MeatGrinder();
		handle = new Handle();
	}

}
