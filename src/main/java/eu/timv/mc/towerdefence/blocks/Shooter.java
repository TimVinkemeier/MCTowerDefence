package eu.timv.mc.towerdefence.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

import java.util.Random;

/**
 * Created by timvi on 09.08.2015.
 */
public class Shooter extends Block {
    public Shooter(Material materialIn) {
        super(materialIn);
        System.out.println("Shooter created");
    }

    @Override
    public IBlockState onBlockPlaced(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer) {
        worldIn.scheduleUpdate(pos, this, 10);
        return super.onBlockPlaced(worldIn, pos, facing, hitX, hitY, hitZ, meta, placer);
    }

    @Override
    public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand) {
        EntityLivingBase player = worldIn.getClosestPlayer(pos.getX() + 0.5D, pos.getY() + 0.5D, pos.getZ() + 0.5D, 15);
        if (player != null) {
            Vec3 offset = new Vec3(player.getPosition().getX(), player.getPosition().getY(), player.getPosition().getZ()).subtract(pos.getX(), pos.getY(), pos.getZ()).normalize();
            EntityArrow arrow = new EntityArrow(worldIn, pos.getX() + 0.5d + offset.xCoord * 1.1, pos.getY() + 0.5d, pos.getZ() + 0.5d + offset.zCoord * 1.1);
            //double degree = 180 / Math.PI;
            double dx = player.posX - (pos.getX() + 0.5);
            double dy = (player.posY + player.getEyeHeight()) - (pos.getY() + 0.5);
            double dz = player.posZ - (pos.getZ() + 0.5);
            //double yaw = -((Math.atan2(dx, dz) * degree) + 180);
            //double pitch = (Math.atan2(dy, Math.sqrt(dx * dx + dz * dz)) * degree);
            double yaw = -Math.atan2(dx, dz);
            double pitch = Math.atan2(dy, Math.sqrt(dx * dx + dz * dz));
            double cosPitch = Math.cos(pitch);

            double X = -(cosPitch * Math.sin(yaw)); // Shorten X down from 1 based on the angle of pitch. We negate because a yaw of -90 or 270 (South) should be +1 not -1 (+yaw is clockwise whereas radians are normally counter-clockwise)
            double Y = -Math.sin(pitch);       // Y based on the angle of pitch. We negate because -90 points up and should be +1 not -1
            double Z = cosPitch * Math.cos(yaw);    // Shorten Z down from 1 based on the angle of pitch

            arrow.setThrowableHeading(X, Y, Z, 2.5f, 0f);
            worldIn.spawnEntityInWorld(arrow);
        }
        worldIn.scheduleUpdate(pos, this, 10);
    }
}
