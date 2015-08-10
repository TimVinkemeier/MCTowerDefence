package eu.timv.mc.towerdefence.blocks;

import net.minecraft.entity.Entity;
import net.minecraft.server.gui.IUpdatePlayerListBox;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ChatComponentText;

/**
 * Created by timvi on 09.08.2015.
 */
public class ShooterTileEntity extends TileEntity implements IUpdatePlayerListBox {

    @Override
    public void update() {
        System.out.println("Ticked!");
        Entity Player = this.worldObj.getClosestPlayer(this.pos.getX() + 0.5D, this.pos.getY() + 0.5D, this.pos.getZ() + 0.5D, 15);
        if (Player != null)
            Player.addChatMessage(new ChatComponentText("Found you!"));
    }
}
