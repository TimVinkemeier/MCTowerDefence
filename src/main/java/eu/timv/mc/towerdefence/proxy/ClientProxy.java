package eu.timv.mc.towerdefence.proxy;

import eu.timv.mc.towerdefence.TowerDefenceBlocks;

/**
 * Created by timvi on 09.08.2015.
 */
public class ClientProxy extends CommonProxy {
    @Override
    public void registerRenders() {
        //TowerDefenceItems.registerRenders();
        TowerDefenceBlocks.registerRenders();
    }
}
