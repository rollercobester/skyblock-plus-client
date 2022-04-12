package net.wurstclient.forge.compatibility;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;

public final class WBlock {
	
	public static IBlockState getState(BlockPos pos) {
		return WMinecraft.getWorld().getBlockState(pos);
	}
	
	public static Block getBlock(BlockPos pos) {
		return getState(pos).getBlock();
	}
	
	public static int getId(BlockPos pos) {
		return Block.getIdFromBlock(getBlock(pos));
	}
	
	public static String getName(Block block) {
		return "" + Block.REGISTRY.getNameForObject(block);
	}
	
	public static Material getMaterial(BlockPos pos) {
		return getState(pos).getMaterial();
	}
	
	public static int getIntegerProperty(IBlockState state, PropertyInteger prop) {
		return state.getValue(prop);
	}
	
	public static AxisAlignedBB getBoundingBox(BlockPos pos) {
		return getState(pos).getBoundingBox(WMinecraft.getWorld(), pos).offset(pos);
	}
	
	public static boolean canBeClicked(BlockPos pos) {
		return getBlock(pos).canCollideCheck(getState(pos), false);
	}
	
	public static float getHardness(BlockPos pos) {
		return getState(pos).getPlayerRelativeBlockHardness(WMinecraft.getPlayer(), WMinecraft.getWorld(), pos);
	}
	
}