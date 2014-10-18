package huter.betterbones.main;

import net.minecraftforge.common.MinecraftForge;
import huter.betterbones.main.blocks.ModBlocks;
import huter.betterbones.main.guis.GuiHandler;
import huter.betterbones.main.handlers.CraftingHandler;
import huter.betterbones.main.handlers.DropEventsHandler;
import huter.betterbones.main.handlers.SmeltingHandler;
import huter.betterbones.main.items.ModItems;
import huter.betterbones.main.lib.Constants;
import huter.betterbones.main.proxies.CommonProxy;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;

@Mod(modid = Constants.MODID, name = Constants.MODNAME, version = Constants.VERSION)
public class BetterBones {

	@SidedProxy(clientSide = "huter.betterbones.main.proxies.ClientProxy", serverSide = "huter.betterbones.main.proxies.CommonProxy")
    public static CommonProxy proxy;
	
	@Instance("betterbones")
	public static BetterBones instance;
	
	@Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
		
		MinecraftForge.EVENT_BUS.register(new DropEventsHandler());
		
		ModItems.init();
		ModBlocks.init();
    }

	@Mod.EventHandler
    public void init(FMLInitializationEvent event) {
    	CraftingHandler.init();
    	SmeltingHandler.init();
    	NetworkRegistry.INSTANCE.registerGuiHandler(this, new GuiHandler());
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {

    }
}
