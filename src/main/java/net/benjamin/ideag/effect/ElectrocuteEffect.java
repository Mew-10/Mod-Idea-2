package net.benjamin.ideag.effect;

import net.benjamin.ideag.damage.ElectrocutedDamageSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;

public class ElectrocuteEffect extends MobEffect {
    public ElectrocuteEffect(MobEffectCategory p_19451_, int p_19452_) {
        super(MobEffectCategory.HARMFUL, 16774738);
    }
    @Override
    public void applyEffectTick(LivingEntity pLivingEntity, int pAmplifier){
        pLivingEntity.hurt(ElectrocutedDamageSource.ELECTROCUTED, 3);
        if (!pLivingEntity.level.isClientSide()) {
            Double x = pLivingEntity.getX();
            Double y = pLivingEntity.getY();
            Double z = pLivingEntity.getZ();

            pLivingEntity.teleportTo(x, y, z);
            pLivingEntity.setDeltaMovement(0, 0, 0);
        }
        super.applyEffectTick(pLivingEntity, pAmplifier);
    }

    @Override
    public boolean isDurationEffectTick(int pDuration, int pAmplifier) {
        return true;
    }
}