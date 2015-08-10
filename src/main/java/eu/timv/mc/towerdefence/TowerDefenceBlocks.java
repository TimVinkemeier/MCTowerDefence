package eu.timv.mc.towerdefence;

import eu.timv.mc.towerdefence.blocks.Shooter;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Created by timvi on 09.08.2015.
 */
public class TowerDefenceBlocks {

    public static Block shooter;
    public static final String shooter_ULN = "shooter";

    public static void init() {
        shooter = new Shooter(Material.cloth).setUnlocalizedName(shooter_ULN);
    }

    public static void register() {
        GameRegistry.registerBlock(shooter, shooter_ULN);
    }

    public static void registerRenders() {
        registerRender(shooter);
    }

    public static void registerRender(Block block) {
        Item item = Item.getItemFromBlock(block);
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(TowerDefence.MODID + ":" + item.getUnlocalizedName().substring(5), "inventory"));
    }
}
