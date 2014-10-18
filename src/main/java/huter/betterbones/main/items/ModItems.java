package huter.betterbones.main.items;

import net.minecraft.item.Item;

public class ModItems {

	public static Item animalbone;
	public static Item cookedanimalbone;
	public static Item rawanimalbone;
	public static Item cookedanimalchunks;
	public static Item rawanimalchunks;

	public static void init() {
		animalbone = new AnimalBone();
		cookedanimalbone = new AnimalBoneCooked();
		rawanimalbone = new AnimalBoneRaw();
		cookedanimalchunks = new CookedAnimalChunks();
		rawanimalchunks = new RawAnimalChunks();
	}

}
