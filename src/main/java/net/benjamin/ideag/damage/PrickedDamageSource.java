package net.benjamin.ideag.damage;

import net.minecraft.world.damagesource.DamageSource;

public class PrickedDamageSource extends DamageSource {
    public static final DamageSource PRICKED = ((PrickedDamageSource) new PrickedDamageSource("pricked_to_death").bypassArmor());

    protected PrickedDamageSource(String name) {
        super(name);
    }
}
