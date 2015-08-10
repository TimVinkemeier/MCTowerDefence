package eu.timv.mc.towerdefence;

import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Created by timvi on 09.08.2015.
 */
public class TowerDefenceItems {

    public static Item shooter;
    public static final String shooter_ULN = "shooter";

    public static void init() {
        shooter = new Item().setUnlocalizedName(shooter_ULN);
    }

    public static void register() {
        GameRegistry.registerItem(shooter, shooter_ULN);
    }

    public static void registerRenders() {
        registerRender(shooter);
    }

    public static void registerRender(Item item) {
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(TowerDefence.MODID + ":" + item.getUnlocalizedName().substring(5), "inventory"));
    }
}
