package eu.timv.mc.towerdefence;

import eu.timv.mc.towerdefence.proxy.CommonProxy;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = TowerDefence.MODID, version = TowerDefence.VERSION, dependencies = "required-after:FML")
public class TowerDefence {
    public static final String MODID = "td";
    public static final String VERSION = "1.0";

    @Instance(value = MODID)
    private TowerDefence instance;

    @SidedProxy(clientSide = "eu.timv.mc.towerdefence.proxy.ClientProxy", serverSide = "eu.timv.mc.towerdefence.proxy.CommonProxy", modId = TowerDefence.MODID)
    public static CommonProxy proxy;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        //TowerDefenceItems.init();
        //TowerDefenceItems.register();
        TowerDefenceBlocks.init();
        TowerDefenceBlocks.register();
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        proxy.registerRenders();
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {

    }
}
