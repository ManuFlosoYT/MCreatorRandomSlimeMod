package net.manufloso.randomslimemod.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

public class SlimeBootsTickEventProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		entity.fallDistance = 0;
		if (!entity.isShiftKeyDown() && entity.getDeltaMovement().y() <= -0.5 && !world.isEmptyBlock(BlockPos.containing(x, y - 1, z))) {
			entity.setDeltaMovement(new Vec3((entity.getDeltaMovement().x()), (entity.getDeltaMovement().y() * (-0.9)), (entity.getDeltaMovement().z())));
			entity.push((entity.getLookAngle().x * 1), 0, (entity.getLookAngle().z * 1));
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.ITEM_SLIME, x, (y - 1), z, 50, 1.5, 1, 1.5, 10);
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.slime.squish")), SoundSource.PLAYERS, 1, (float) Mth.nextDouble(RandomSource.create(), 0.85, 1.15));
				} else {
					_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.slime.squish")), SoundSource.PLAYERS, 1, (float) Mth.nextDouble(RandomSource.create(), 0.85, 1.15), false);
				}
			}
		}
	}
}
